package example.domain.model.spacification.discount.group;

import example.domain.model.spacification.amount.Rate;

import java.math.BigDecimal;

/**
 * 団体割引率
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
