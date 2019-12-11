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

    public boolean _30人以下() {
        return value <= 30;
    }

    public NumberOfPeople 団体割引人数() {
        BigDecimal[] divideAndRemainder = decimalValue().divideAndRemainder(BigDecimal.valueOf(50));
        BigDecimal divide = divideAndRemainder[0];
        return new NumberOfPeople(divide.intValue() + 1);
    }
}
