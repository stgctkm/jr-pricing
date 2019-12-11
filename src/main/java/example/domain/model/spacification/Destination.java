package example.domain.model.spacification;

import java.math.BigDecimal;

/**
 * 目的地
 */
public enum Destination {
    新大阪(new FareAmount(BigDecimal.valueOf(8910)),new FareAmount(BigDecimal.valueOf(5490)), new OneWayDistance(553)),
    姫路(new FareAmount(BigDecimal.valueOf(10010)), new FareAmount(BigDecimal.valueOf(5920)), new OneWayDistance(644));

    FareAmount 基本料金;
    FareAmount 特急料金;

    OneWayDistance 片道距離;

    Destination(FareAmount 基本料金, FareAmount 特急料金, OneWayDistance 片道距離) {
        this.基本料金 = 基本料金;
        this.特急料金 = 特急料金;
        this.片道距離 = 片道距離;
    }

    public boolean is新大阪() {
        return this == 新大阪;
    }

    public FareAmount までの特急料金() {
        return 特急料金;
    }

    public FareAmount までの基本料金() {
        return 基本料金;
    }

    public boolean 往復割引の対象() {
        return 片道距離.is往復割引対象();
    }
}
