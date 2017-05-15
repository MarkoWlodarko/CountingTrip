package test;


import MW.exception.MaxLoadExceededException;
import MW.exception.MaxPassengerExceededException;
import MW.service.Car;
import MW.trip.Trip;
import MW.trip.Voyager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by reynev on 3/20/17.
 */
class TripTest {

    @Test
    @DisplayName("Custom Test")
    void addVoyager() throws MaxLoadExceededException, MaxPassengerExceededException {
        Trip trip = new Trip(createMercedes(), 43.8);

        Voyager zanetka = new Voyager("Żanetka", 52.5, 90);
        Voyager marek = new Voyager("Marek", 74.3, 30);
        Voyager marcin = new Voyager("Marcin", 80.0, 30);
        Voyager agata = new Voyager("Agata", 53.0, 90);
//            Voyager agata2 = new Voyager("Agata", 53.0, 90);

        trip.addVoyager(zanetka);
        trip.addVoyager(marek);
        trip.addVoyager(agata);
        trip.addVoyager(marcin);

        assertTrue(trip.countNumOfPassengers() <= createMercedes().getMaxLoad(),"Max load of passangers in car were not exceeded");
        assertNotSame(zanetka, marek, "Passangers are not same");


        assertAll("weight of voyagers",
                () -> assertTrue(zanetka.getWeight() > 0),
                () -> assertTrue(marek.getWeight() > 0),
                () -> assertTrue(agata.getWeight() > 0),
                () -> assertTrue(marcin.getWeight() > 0));

    }

    private static Car createMercedes() {
        Car car = new Car(8,4, 500.0);
        return car;
    }
}