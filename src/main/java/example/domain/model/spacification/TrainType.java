package example.domain.model.spacification;

/**
 * 列車種類
 */
public enum TrainType {
    のぞみ(320, 530),
    ひかり(0, 0);

    int 大阪までの特急割増料金;
    int 姫路までの特急割増料金;


    TrainType(int 大阪までの特急割増料金, int 姫路までの特急割増料金) {
        this.大阪までの特急割増料金 = 大阪までの特急割増料金;
        this.姫路までの特急割増料金 = 姫路までの特急割増料金;
    }

    public int 特急割増料金(Destination destination) {
        if (destination.is新大阪())
            return 大阪までの特急割増料金;
        return 姫路までの特急割増料金;

    }
}
