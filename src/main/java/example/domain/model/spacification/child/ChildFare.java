package example.domain.model.spacification.child;

import example.domain.model.spacification.amount.FareAmount;

/**
 * 子供料金
 */
public class ChildFare {
    FareAmount 大人の基本料金;
    FareAmount 大人の特急料金;

    public ChildFare(FareAmount 大人の基本料金, FareAmount 大人の特急料金) {
        this.大人の基本料金 = 大人の基本料金;
        this.大人の特急料金 = 大人の特急料金;
    }

    public FareAmount 料金() {
        return 大人の基本料金.半額().add(大人の特急料金.半額()).十円未満の端数切り捨て();
    }
}
