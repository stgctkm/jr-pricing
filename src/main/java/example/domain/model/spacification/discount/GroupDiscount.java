package example.domain.model.spacification.discount;

import example.domain.model.spacification.FareAmount;
import example.domain.model.spacification.NumberOfPeople;

/**
 * 団体割引
 */
public class GroupDiscount {

    NumberOfPeople 人数;

    public GroupDiscount(NumberOfPeople 合計人数) {
        this.人数 = 合計人数;
    }


//    public FareAmount 適用後の基本料金(FareAmount 合計料金) {
//        if (人数._30人以下()) return 合計料金;
//        人数.割引対象人数()
//    }
}
