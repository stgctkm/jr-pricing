package example.domain.model.spacification.schedule;

import example.domain.model.spacification.season.SeasonType;

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
        if (isAfter(MonthDay.of(12, 25))
                && isBefore(MonthDay.of(1, 10)))
            return SeasonType.繁忙期;
        if (isAfter(MonthDay.of(1, 16))
                && isBefore(MonthDay.of(1, 30)))
            return SeasonType.閑散期;
        return SeasonType.通常期;
    }

//    public DiscountRate 割引率() {
//        if (value.isAfter(MonthDay.of(12, 21))
//                && value.isBefore(MonthDay.of(1, 10)))
//            return new DiscountRate(new BigDecimal("0.9"));
//        return new DiscountRate(new BigDecimal("0.85"));
//    }

    public boolean isAfter(MonthDay 日付) {
        return value.isAfter(日付);
    }

    public boolean isBefore(MonthDay 日付) {
        return value.isBefore(日付);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
