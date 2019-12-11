package example.domain.model.spacification.surcharge;

import example.domain.model.spacification.*;

/**
 * 特急料金
 */
public class SuperExpressSurcharge {

    Destination 目的地;
    TrainType trainType;
    DepartureDate 出発日;
    SeatType 座席種類;

    // TODO 指定席の場合
    //  自由席の場合、通年で −530
    public FareAmount 料金() {
        return 目的地.までの特急料金()
                .add(trainType.特急割増料金(目的地))
                .add(季節での加算料金());
    }

    // TODO 要refactor
    FareAmount 季節での加算料金() {
        if (座席種類.is自由席()) {
            return 座席種類.割引額();
        }
        return 出発日.季節区分().加算料金();
    }


    public SuperExpressSurcharge(Destination 目的地, TrainType trainType, DepartureDate 出発日, SeatType 座席種類) {
        this.目的地 = 目的地;
        this.trainType = trainType;
        this.出発日 = 出発日;
        this.座席種類 = 座席種類;
    }
}
