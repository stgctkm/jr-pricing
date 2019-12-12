package example.domain.model.spacification.surcharge.train;

import example.domain.model.spacification.amount.FareAmount;
import example.domain.model.spacification.destination.Destination;

import java.math.BigDecimal;

/**
 * 列車種類
 */
public enum TrainType {
    のぞみ(320, 530),
    ひかり(0, 0);

    FareAmount 大阪までの特急割増料金;
    FareAmount 姫路までの特急割増料金;


    TrainType(int 大阪までの特急割増料金, int 姫路までの特急割増料金) {
        this.大阪までの特急割増料金 = new FareAmount(BigDecimal.valueOf(大阪までの特急割増料金));
        this.姫路までの特急割増料金 = new FareAmount(BigDecimal.valueOf(姫路までの特急割増料金));;
    }

    public FareAmount 特急割増料金(Destination destination) {
        if (destination.is新大阪())
            return 大阪までの特急割増料金;
        return 姫路までの特急割増料金;

    }
}
