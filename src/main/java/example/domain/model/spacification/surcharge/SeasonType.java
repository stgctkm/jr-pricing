package example.domain.model.spacification.surcharge;

import example.domain.model.spacification.FareAmount;

import java.math.BigDecimal;

/**
 * 季節区分
 */
public enum SeasonType {
    通常期(0),
    閑散期(-200),
    繁忙期(200),
    ;

    FareAmount 加算料金;

    SeasonType(int 加算料金) {
        this.加算料金 = new FareAmount(BigDecimal.valueOf(加算料金));
    }

    public FareAmount 加算料金() {
        return 加算料金;
    }
}
