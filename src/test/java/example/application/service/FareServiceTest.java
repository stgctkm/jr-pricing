package example.application.service;

import example.domain.model.attempt.Attempt;
import example.domain.model.bill.Amount;
import example.domain.model.rules.DistanceTable;
import example.domain.model.rules.FareTable;
import example.domain.model.rules.SurchargeTable;
import example.domain.model.spacification.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FareServiceTest {

    static private FareService fareService;

    static private FareTable fareTable;
    static private SurchargeTable surchargeTable;
    static private DistanceTable distanceTable;

    @BeforeAll
    static void setUp() {
        fareTable = new FareTable();
        surchargeTable = new SurchargeTable();
        distanceTable = new DistanceTable();

        fareService = new FareService(fareTable, surchargeTable, distanceTable);
    }

    @Test
    void 基本() {
        Attempt attempt = AttemptFactory.大人1_通常期_新大阪_指定席_ひかり_片道();
        Amount result = fareService.amountFor(attempt);
        Destination destination = Destination.新大阪;
        Amount expected = new Amount(fareTable.fare(destination) + surchargeTable.surcharge(destination));
        assertEquals(expected, result);
    }

    @Test
    void 新大阪までののぞみの一人料金() {
        Attempt attempt = new Attempt(1, 0, new DepartureDate("2019-10-01"), Destination.新大阪, SeatType.指定席, TrainType.のぞみ, TripType.片道);
        assertEquals(8910 + 5490 + 320, attempt.料金());

    }
}