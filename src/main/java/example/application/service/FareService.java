package example.application.service;

import example.domain.model.attempt.Attempt;
import example.domain.model.bill.Amount;
import example.application.service.rules.DistanceTable;
import example.application.service.rules.FareTable;
import example.application.service.rules.SurchargeTable;
import example.domain.model.spacification.plan.destination.Destination;
import org.springframework.stereotype.Service;

/**
 * 料金計算サービス
 */
@Service
public class FareService {

    FareTable fareTable;
    SurchargeTable surchargeTable;
    DistanceTable distanceTable;

    public FareService(FareTable fareTable, SurchargeTable surchargeTable, DistanceTable distanceTable) {
        this.fareTable = fareTable;
        this.surchargeTable = surchargeTable;
        this.distanceTable = distanceTable;
    }

    public Amount amountFor(Attempt attempt) {
        // 仮実装（ひかり、大人１名）
        Destination to = attempt.to();
        Amount fare = new Amount(fareTable.fare(to) + surchargeTable.surcharge(to));
        return fare;
    }
}
