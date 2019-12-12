package example.domain.model.spacification.trip;

import example.domain.model.spacification.amount.FareAmount;

/**
 * 片道料金
 */
public class OneWayTicketFareAmount implements TicketTypeFareAmount {
    @Override
    public FareAmount 料金(FareAmount 料金) {
        return 料金;
    }
}
