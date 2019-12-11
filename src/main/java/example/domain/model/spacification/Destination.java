package example.domain.model.spacification;

/**
 * 目的地
 */
public enum Destination {
    新大阪(8910,5490),
    姫路(10010, 5920);

    int 基本料金;
    int 特急料金;

    Destination(int 基本料金, int 特急料金) {
        this.基本料金 = 基本料金;
        this.特急料金 = 特急料金;
    }

    public boolean is新大阪() {
        return this == 新大阪;
    }

    public int までの特急料金() {
        return 特急料金;
    }

    public int までの基本料金() {
        return 基本料金;
    }
}
