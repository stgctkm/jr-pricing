package example.domain.model.spacification.discount;

import example.domain.model.spacification.FareAmount;
import example.domain.model.spacification.NumberOfPeople;

import java.math.BigDecimal;

/**
 * 大人数の団体割引
 */
public class LargeGroupDiscount {

    FareAmount 大人片道料金;
    NumberOfPeople 人数;

    public LargeGroupDiscount(FareAmount 大人片道料金, NumberOfPeople 合計人数) {
        this.大人片道料金 = 大人片道料金;
        this.人数 = 合計人数;
    }

    public FareAmount 割引料金() {
        if (人数._30人以下()) {
            return new FareAmount(BigDecimal.ZERO);
        }
        return 大人片道料金.人数分の料金(人数.団体割引人数());

    }


//    public FareAmount 適用後の基本料金(FareAmount 合計料金) {
//        if (人数._30人以下()) return 合計料金;
//        人数.割引対象人数()
//    }
}
