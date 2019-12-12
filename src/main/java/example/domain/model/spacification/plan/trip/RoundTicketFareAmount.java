package example.domain.model.spacification.plan.trip;

import example.domain.model.spacification.amount.FareAmount;

/**
 * 往復料金
 */
public class RoundTicketFareAmount implements TicketTypeFareAmount {
    @Override
    public FareAmount 料金(FareAmount 料金) {
        return 料金.倍額();
    }
}
