package example.domain.model.spacification.discount;

import example.domain.model.spacification.schedule.DepartureDate;
import example.domain.model.spacification.NumberOfPeople;

import java.math.BigDecimal;

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

    public DiscountRate 割引料金() {
        if (人数._8人未満() || !人数._30人以下()) {
            return new DiscountRate(BigDecimal.ONE);
        }

        return 出発日.割引率();

    }


//    public FareAmount 適用後の基本料金(FareAmount 合計料金) {
//        if (人数._30人以下()) return 合計料金;
//        人数.割引対象人数()
//    }
}
