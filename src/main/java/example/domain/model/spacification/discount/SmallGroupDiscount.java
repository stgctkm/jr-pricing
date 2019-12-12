package example.domain.model.spacification.discount;

import example.domain.model.spacification.amount.FareAmount;
import example.domain.model.spacification.schedule.DepartureDate;
import example.domain.model.spacification.NumberOfPeople;

import java.math.BigDecimal;
import java.time.MonthDay;

/**
 * 少人数の団体割引
 */
public class SmallGroupDiscount {

    NumberOfPeople 人数;
    DepartureDate 出発日;

    public SmallGroupDiscount(NumberOfPeople 人数, DepartureDate departureDate) {
        this.人数 = 人数;
        this.出発日 = departureDate;
    }

    DiscountRate 割引料金() {
        if (人数._8人未満() || !人数._30人以下()) {
            return new DiscountRate(BigDecimal.ONE);
        }
        return 割引率();
    }

    // TODO NumberOfPeopleを使っていないので、
    //  DepartureDateに移動したいが、
    //  移動すると双方向の依存になってしまう
    //  少人数の割引率はこのクラスにあったほうが良いかも
    private DiscountRate 割引率() {
        if (出発日.isAfter(MonthDay.of(12, 21))
                && 出発日.isBefore(MonthDay.of(1, 10)))
            return new DiscountRate(new BigDecimal("0.9"));
        return new DiscountRate(new BigDecimal("0.85"));
    }

    public FareAmount 適用する(FareAmount 合計料金) {
        return 合計料金.multiply(割引料金())
                .十円未満の端数切り捨て();
    }

}
