package example.domain.model.spacification.discount.roundtrip;

import example.domain.model.spacification.destination.Destination;
import example.domain.model.spacification.amount.FareAmount;
import example.domain.model.spacification.discount.group.DiscountRate;

import java.math.BigDecimal;

/**
 * 往復割引
 */
public class RoundTripDiscount {

    Destination 目的地;

    DiscountRate 割引率 = new DiscountRate(new BigDecimal("0.9"));

    public RoundTripDiscount(Destination 目的地) {
        this.目的地 = 目的地;
    }

    public FareAmount 適用後の基本料金(FareAmount 基本料金) {

        if (!目的地.往復割引の対象()) return 基本料金;

        FareAmount 割引料金 = 基本料金.multiply(割引率);
        return 割引料金.十円未満の端数切り捨て();
    }
}
