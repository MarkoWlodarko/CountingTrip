package test;


import MW.exception.MaxLoadExceededException;
import MW.exception.MaxPassengerExceededException;
import MW.service.Car;
import MW.service.TripCostsCalculator;
import MW.trip.Trip;
import MW.trip.Voyager;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by reynev on 3/20/17.
 */
class TripTest {

    @Test
    @Disabled
    @DisplayName("Custom Test")
    void testHappyPath() throws MaxLoadExceededException, MaxPassengerExceededException {
        //given
        Trip trip = new Trip(createMercedes(), 800.915676);

        Voyager zanetka = new Voyager("Żanetka", 55.0, 20);
        Voyager marek = new Voyager("Marek", 70, 20);
        Voyager marcin = new Voyager("Marcin", 70.0, 20);
        Voyager agata = new Voyager("Agata", 55.0, 20);

        trip.addVoyager(zanetka);
        trip.addVoyager(marek);
        trip.addVoyager(agata);
        trip.addVoyager(marcin);

        //when
        TripCostsCalculator calculator = new TripCostsCalculator();
        double overallCost = calculator.calcOverallCost(trip);
        double costPerPassenger = calculator.calcCostPerPassenger(trip);

        //then
        assertEquals(overallCost, 240.2747028, 0.0001);
        assertEquals(costPerPassenger, 60.068625, 0.0001);
    }

    @Test
    void testLoadExceeded() throws MaxLoadExceededException, MaxPassengerExceededException {
        //given
        Trip trip = new Trip(createMercedes(), 800.915676);

        Voyager zanetka = new Voyager("Żanetka", 55.0, 100);
        Voyager marek = new Voyager("Marek", 70, 200);
        Voyager marcin = new Voyager("Marcin", 70.0, 100);
        Voyager agata = new Voyager("Agata", 55.0, 1000);

        trip.addVoyager(zanetka);
        trip.addVoyager(marek);

        //when
        MaxLoadExceededException maxLoadExceededException = null;
        try{
            trip.addVoyager(agata);
            fail("");
        }catch (MaxLoadExceededException e){
            maxLoadExceededException = e;
        }

        //then
        assertEquals(500, maxLoadExceededException.getMaxLoad());

    }

    private static Car createMercedes() {
        Car car = new Car(6,5, 500.0);
        return car;
    }
}