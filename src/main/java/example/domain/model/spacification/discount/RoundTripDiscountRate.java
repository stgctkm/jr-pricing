package example.domain.model.spacification.discount;

import java.math.BigDecimal;

public class RoundTripDiscountRate {
    BigDecimal value;

    public RoundTripDiscountRate(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal value() {
        return value;
    }
}
