package test;


import MW.exception.MaxLoadExceededException;
import MW.exception.MaxPassengerExceededException;
import MW.service.Car;
import MW.trip.Trip;
import MW.trip.Voyager;

/**
 * Created by reynev on 3/20/17.
 */
class TripTest {


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


    }

    private static Car createMercedes() {
        Car car = new Car(8,4, 500.0);
        return car;
    }
}