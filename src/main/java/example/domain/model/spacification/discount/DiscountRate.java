package example.domain.model.spacification.discount;

import example.domain.model.spacification.amount.Rate;

import java.math.BigDecimal;

/**
 * 割引率
 */
public class DiscountRate implements Rate {
    BigDecimal value;

    public DiscountRate(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }
}
