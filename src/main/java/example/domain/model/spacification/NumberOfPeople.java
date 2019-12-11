package example.domain.model.spacification;

import java.math.BigDecimal;

public class NumberOfPeople {
    int value;

    public NumberOfPeople(int value) {
        this.value = value;
    }

    public BigDecimal decimalValue() {
        return BigDecimal.valueOf(value);
    }
}
