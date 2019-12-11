package example.domain.model.spacification.surcharge;

import example.domain.model.spacification.Destination;
import example.domain.model.spacification.TrainType;

/**
 * 特急料金
 */
public class SuperExpressSurcharge {

    Destination 目的地;
    TrainType trainType;

    public int 料金() {
        return 目的地.までの特急料金() + trainType.特急割増料金(目的地);
    }

    public SuperExpressSurcharge(Destination 目的地, TrainType trainType) {
        this.目的地 = 目的地;
        this.trainType = trainType;
    }
}
