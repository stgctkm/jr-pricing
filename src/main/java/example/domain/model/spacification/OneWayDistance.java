package example.domain.model.spacification;

public class OneWayDistance {

    int value;

    public OneWayDistance(int value) {
        this.value = value;
    }

    public boolean is往復割引対象() {
        return value >= 601;
    }
}
