package example.application.service;

import example.domain.model.attempt.Attempt;
import example.domain.model.bill.Amount;
import example.application.service.rules.DistanceTable;
import example.application.service.rules.FareTable;
import example.application.service.rules.SurchargeTable;
import example.domain.model.spacification.plan.destination.Destination;
import example.domain.model.spacification.plan.schedule.DepartureDate;
import example.domain.model.spacification.surcharge.seat.SeatType;
import example.domain.model.spacification.surcharge.train.TrainType;
import example.domain.model.spacification.plan.tickettype.TicketType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
        Attempt attempt = new Attempt(1, 0, new DepartureDate("2019-10-01"), Destination.新大阪, SeatType.指定席, TrainType.のぞみ, TicketType.片道);
        assertEquals(8910 + 5490 + 320, attempt.料金().intValue());
    }

    @Test
    void 新大阪までののぞみの子供一人片道料金() {
        Attempt attempt = new Attempt(0, 1, new DepartureDate("2019-10-01"), Destination.新大阪, SeatType.指定席, TrainType.のぞみ, TicketType.片道);
        assertEquals((8910 + 5490 + 320) / 2, attempt.子供料金().intValue());
    }

    @Test
    void 姫路までののぞみの一人往復料金() {
        Attempt attempt = new Attempt(0, 1, new DepartureDate("2019-10-01"), Destination.姫路, SeatType.指定席, TrainType.のぞみ, TicketType.往復);
        assertEquals((9000 + 5920 + 530) * 2, attempt.料金().intValue());
    }

    @Test
    void 新大阪までののぞみの大人2人_子供3人の料金() {
        Attempt attempt = new Attempt(2, 3, new DepartureDate("2019-10-01"), Destination.新大阪, SeatType.指定席, TrainType.のぞみ, TicketType.片道);
        assertEquals((8910 + 5490 + 320) *2 + (8910 + 5490 + 320) /2 *3, attempt.合計料金().intValue());
    }

    @Test
    void 新大阪までののぞみの大人60人料金() {
        Attempt attempt = new Attempt(60, 0, new DepartureDate("2019-10-01"), Destination.新大阪, SeatType.指定席, TrainType.のぞみ, TicketType.片道);
        assertEquals((8910 + 5490 + 320) * 58, attempt.合計料金().intValue());
    }

    @Test
    void 新大阪までののぞみの大人9人料金() {
        Attempt attempt = new Attempt(9, 0, new DepartureDate("2019-10-01"), Destination.新大阪, SeatType.指定席, TrainType.のぞみ, TicketType.片道);
        assertEquals(112600/* (8910 + 5490 + 320) * 9 * 0.85 の10円未満切り捨て */, attempt.合計料金().intValue());
    }
}