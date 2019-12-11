package example.domain.model.spacification;

import example.domain.model.spacification.discount.RoundTripDiscountRate;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FareAmount {
    BigDecimal value;

    public FareAmount(BigDecimal value) {
        this.value = value;
    }

    public int intValue() {
        return value.intValue();
    }

    public FareAmount multiply(RoundTripDiscountRate rate) {
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
}
