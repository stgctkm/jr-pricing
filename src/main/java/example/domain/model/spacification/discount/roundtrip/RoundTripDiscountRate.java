package example.domain.model.spacification.discount.roundtrip;

import example.domain.model.spacification.amount.Rate;

import java.math.BigDecimal;

/**
 * 往復割引率
 */
public class RoundTripDiscountRate implements Rate {
    BigDecimal value;

    public RoundTripDiscountRate(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }
}
