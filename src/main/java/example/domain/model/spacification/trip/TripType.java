package example.domain.model.spacification.trip;

import example.domain.model.spacification.FareAmount;

/**
 * 片道/往復
 */
public enum TripType {
    片道(new OneWayTripFareAmount()),
    往復(new RoundTripFareAmount()),
    ;

    TripTypeFareAmount tripTypeFareAmount;

    TripType(TripTypeFareAmount tripTypeFareAmount) {
        this.tripTypeFareAmount = tripTypeFareAmount;
    }

    public FareAmount 料金(FareAmount 片道料金) {
        return tripTypeFareAmount.料金(片道料金);
    }

    public boolean is片道() {
        return this == 片道;
    }

}