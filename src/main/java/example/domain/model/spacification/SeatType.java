package example.domain.model.spacification;

import java.math.BigDecimal;

/**
 * 座席区分
 */
public enum SeatType {
    指定席(0),
    自由席(-530);

    FareAmount 割引額;

    SeatType(int 割引額) {
        this.割引額 = new FareAmount(BigDecimal.valueOf(割引額));
    }

    public FareAmount 割引額() {
        return 割引額;
    }

    public boolean is自由席() {
        return this == 自由席;
    }

//    public FareAmount 加算料金(SeasonType 季節区分) {
//        季節区分.加算料金()
//    }
}
