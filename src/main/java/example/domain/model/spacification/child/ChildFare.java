package example.domain.model.spacification.child;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 子供料金
 */
public class ChildFare {
    int 大人の基本料金;
    int 大人の特急料金;

    public ChildFare(int 大人の基本料金, int 大人の特急料金) {
        this.大人の基本料金 = 大人の基本料金;
        this.大人の特急料金 = 大人の特急料金;
    }

    public int 料金() {
        return BigDecimal.valueOf(大人の基本料金 / 2 + 大人の特急料金 / 2)
                .setScale(0, RoundingMode.HALF_DOWN)
                .intValue();
    }
}
