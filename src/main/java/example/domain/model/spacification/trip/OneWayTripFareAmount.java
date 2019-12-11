package example.domain.model.spacification.trip;

import example.domain.model.spacification.FareAmount;

public class OneWayTripFareAmount implements TripTypeFareAmount {
    @Override
    public FareAmount 料金(FareAmount 料金) {
        return 料金;
    }
}
