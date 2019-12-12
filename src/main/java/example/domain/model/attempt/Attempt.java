package example.domain.model.attempt;

import example.domain.model.spacification.*;
import example.domain.model.spacification.amount.FareAmount;
import example.domain.model.spacification.child.ChildFare;
import example.domain.model.spacification.destination.Destination;
import example.domain.model.spacification.discount.LargeGroupDiscount;
import example.domain.model.spacification.discount.SmallGroupDiscount;
import example.domain.model.spacification.fare.BasicFare;
import example.domain.model.spacification.schedule.DepartureDate;
import example.domain.model.spacification.seat.SeatType;
import example.domain.model.spacification.surcharge.SuperExpressSurcharge;
import example.domain.model.spacification.train.TrainType;
import example.domain.model.spacification.trip.TripType;

/**
 * 購入希望
 */
public class Attempt {
    int adult;
    int child;

    DepartureDate departureDate;
    Destination destination;

    SeatType seatType;
    TrainType trainType;
    TripType tripType;

    public Attempt(int adult, int child, DepartureDate departureDate, Destination destination, SeatType seatType, TrainType trainType, TripType tripType) {
        this.adult = adult;
        this.child = child;
        this.departureDate = departureDate;
        this.destination = destination;
        this.seatType = seatType;
        this.trainType = trainType;
        this.tripType = tripType;
    }

    public Destination to() {
        return destination;
    }

    @Override
    public String toString() {
        return "大人=" + adult + "人" +
                "\n子供=" + child + "人" +
                "\n出発日=" + departureDate +
                "\n目的地=" + destination +
                "\n座席区分=" + seatType +
                "\n列車種類=" + trainType +
                "\n片道/往復=" + tripType
                ;
    }

    public FareAmount 料金() {
        FareAmount 片道料金 = 大人片道料金();
        return tripType.料金(片道料金);
    }

    private FareAmount 大人片道料金() {
        FareAmount 片道基本料金 = new BasicFare(destination).基本料金(tripType);
        FareAmount 片道特急料金 = new SuperExpressSurcharge(destination, trainType, departureDate, seatType).料金();

        return 片道基本料金.add(片道特急料金);
    }

    public FareAmount 子供料金() {
        FareAmount 基本料金 = new BasicFare(destination).基本料金(tripType);
        FareAmount 特急料金 = new SuperExpressSurcharge(destination, trainType, departureDate, seatType).料金();
        return new ChildFare(基本料金, 特急料金).料金();
    }

    public NumberOfPeople 合計人数() {
        return new NumberOfPeople(adult + child);
    }

    // TODO 大人４人・子供４人の場合の団体割引は大人に対して適用される？
    public FareAmount 合計料金() {
        FareAmount 合計料金 =
                大人片道料金().人数分の料金(new NumberOfPeople(adult))
                        .add(子供料金().人数分の料金(new NumberOfPeople(child)))
                        .少人数団体割引の適用(new SmallGroupDiscount(合計人数(), departureDate))
                        .多人数団体割引の適用(new LargeGroupDiscount(大人片道料金(), 合計人数()));
        return 合計料金;
    }
}