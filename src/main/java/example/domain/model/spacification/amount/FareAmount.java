package example.domain.model.spacification.amount;

import example.domain.model.spacification.NumberOfPeople;
import example.domain.model.spacification.discount.LargeGroupDiscount;
import example.domain.model.spacification.discount.SmallGroupDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 料金
 */
public class FareAmount {
    BigDecimal value;

    public FareAmount(BigDecimal value) {
        this.value = value;
    }

    public int intValue() {
        return value.intValue();
    }

    public FareAmount multiply(Rate rate) {
        return new FareAmount(value.multiply(rate.value()));
    }

    public FareAmount 十円未満の端数切り捨て() {
        return new FareAmount(value.setScale(-1, RoundingMode.FLOOR));
    }

    public FareAmount 半額() {
        return new FareAmount(value.divide(BigDecimal.valueOf(2)));
    }

    public FareAmount 倍額() {
        return new FareAmount(value.multiply(BigDecimal.valueOf(2)));
    }

    public FareAmount add(FareAmount other) {
        return new FareAmount(value.add(other.value));
    }

    public FareAmount 人数分の料金(NumberOfPeople 人数) {
        return new FareAmount(value.multiply(人数.decimalValue()));
    }

    public FareAmount subtract(FareAmount other) {
        return new FareAmount(value.subtract(other.value));
    }

//    public FareAmount 少人数団体割引の適用(SmallGroupDiscount 団体割引) {
//        return this.multiply(団体割引.割引料金())
//                .十円未満の端数切り捨て();
//    }
//
//    public FareAmount 多人数団体割引の適用(LargeGroupDiscount 団体割引) {
//        return this.subtract(団体割引.割引料金());
//    }
}
