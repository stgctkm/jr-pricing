package example.domain.model.spacification.fare;

import example.domain.model.spacification.Destination;
import example.domain.model.spacification.FareAmount;
import example.domain.model.spacification.discount.RoundTripDiscount;
import example.domain.model.spacification.trip.TripType;

/**
 * 基本料金
 */
public class BasicFare {

    Destination 目的地;

    public BasicFare(Destination 目的地) {
        this.目的地 = 目的地;
    }

    public FareAmount 基本料金(TripType tripType) {

        if (tripType.is片道()) return 目的地.までの基本料金();

        RoundTripDiscount 往復割引 = new RoundTripDiscount(目的地);

        return 往復割引.適用後の基本料金(目的地.までの基本料金());
    }
}
