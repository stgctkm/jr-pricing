package example.domain.model.spacification.trip;

import example.domain.model.spacification.amount.FareAmount;

/**
 * 片道/往復
 */
public enum TripType {
    片道(new OneWayTicketFareAmount()),
    往復(new RoundTicketFareAmount()),
    ;

    TicketTypeFareAmount ticketTypeFareAmount;

    TripType(TicketTypeFareAmount ticketTypeFareAmount) {
        this.ticketTypeFareAmount = ticketTypeFareAmount;
    }

    public FareAmount 料金(FareAmount 片道料金) {
        return ticketTypeFareAmount.料金(片道料金);
    }

    public boolean is片道() {
        return this == 片道;
    }

}