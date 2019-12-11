package example.domain.model.spacification;

import example.domain.model.spacification.discount.DiscountRate;
import example.domain.model.spacification.surcharge.SeasonType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.MonthDay;

/**
 * 出発日
 */
public class DepartureDate {
    MonthDay value;

    public DepartureDate(String textValue) {
        LocalDate date = LocalDate.parse(textValue);
        this.value = MonthDay.from(date);
    }

    public SeasonType 季節区分() {
        if (value.isAfter(MonthDay.of(12, 25))
                && value.isBefore(MonthDay.of(1, 10)))
            return SeasonType.繁忙期;
        if (value.isAfter(MonthDay.of(1, 16))
                && value.isBefore(MonthDay.of(1, 30)))
            return SeasonType.閑散期;
        return SeasonType.通常期;
    }

    public DiscountRate 割引率() {
        if (value.isAfter(MonthDay.of(12, 21))
                && value.isBefore(MonthDay.of(1, 10)))
            return new DiscountRate(new BigDecimal("0.9"));
        return new DiscountRate(new BigDecimal("0.85"));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
