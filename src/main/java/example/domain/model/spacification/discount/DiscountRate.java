package example.domain.model.spacification.discount;

import java.math.BigDecimal;

/**
 * 割引率
 */
public class DiscountRate {
    BigDecimal value;

    public DiscountRate(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }
}
