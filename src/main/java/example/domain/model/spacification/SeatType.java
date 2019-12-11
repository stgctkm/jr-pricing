package example.domain.model.spacification;

/**
 * 座席区分
 */
public enum SeatType {
    指定席(0),
    自由席(530);

    int 割引額;

    SeatType(int 割引額) {
        this.割引額 = 割引額;
    }

    int 割引額() {
        return 割引額;
    }
}
