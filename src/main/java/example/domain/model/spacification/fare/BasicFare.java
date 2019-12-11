package example.domain.model.spacification.fare;

import example.domain.model.spacification.Destination;

/**
 * 基本料金
 */
public class BasicFare {

    Destination 目的地;

    public BasicFare(Destination 目的地) {
        this.目的地 = 目的地;
    }

    public int 基本料金() {
        return 目的地.までの基本料金();
    }
}
