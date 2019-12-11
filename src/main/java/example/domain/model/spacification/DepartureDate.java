package example.domain.model.spacification;

import example.domain.model.spacification.surcharge.SeasonType;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * 出発日
 */
public class DepartureDate {
    LocalDate value;

    public DepartureDate(String textValue) {
        this.value = LocalDate.parse(textValue);
    }

    public SeasonType 季節区分() {
        MonthDay monthDay = MonthDay.from(value);
        if (monthDay.isAfter(MonthDay.of(12, 25))
                && monthDay.isBefore(MonthDay.of(1, 10)))
            return SeasonType.繁忙期;
        if (monthDay.isAfter(MonthDay.of(1, 16))
                && monthDay.isBefore(MonthDay.of(1, 30)))
            return SeasonType.閑散期;
        return SeasonType.通常期;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
