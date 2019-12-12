package example.domain.model.spacification.season;

import example.domain.model.spacification.amount.FareAmount;

import java.math.BigDecimal;

/**
 * 季節区分
 */
public enum SeasonType {
    通常期(0),
    閑散期(-200),
    繁忙期(200),
    ;

    FareAmount 指定席加算料金;

    SeasonType(int 指定席加算料金) {
        this.指定席加算料金 = new FareAmount(BigDecimal.valueOf(指定席加算料金));
    }

    public FareAmount 加算料金() {
        return 指定席加算料金;
    }
}
