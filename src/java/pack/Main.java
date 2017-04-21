package java.pack;

import java.exception.MaxLoadExceededException;
import java.exception.MaxPassengerExceededException;
import java.service.Car;

public class Main{

    public static void main (String args[]) {
        Trip trip = new Trip(createMercedes(), 800);

        try {
            Voyager zanetka = new Voyager("Żanetka", 52.5, 50);
            Voyager marek = new Voyager("Marek", 74.3, 30);
            Voyager marcin = new Voyager("Marcin", 80.0, 30);
            Voyager agata = new Voyager("Agata", 53.0, 5000);
            Voyager agata2 = new Voyager("Agata", 53.0, 200);


            trip.addVoyager(zanetka);
            trip.addVoyager(marek);
            trip.addVoyager(agata);
            trip.addVoyager(marcin);
            trip.addVoyager(agata2);
            trip.doCalculationsPerPassenger(trip);
        } catch (MaxPassengerExceededException e) {
//            System.out.println("Za dużo pasażerów! Maksymalna ilość miejsc wynosi "+ e.getMaxPassengers());
        } catch (MaxLoadExceededException e) {
//            System.out.println("Za duże obciążenie! Maksymalne obciążenie wynosi " + e.getMaxLoad()+", a oczekiwana waga to " + e.getExpectedLoad());
        }
        trip.doOverallCalculation(trip);


    }

    private static Car createMercedes() {
        Car car = new Car(7.5,4, 500.0);
        return car;
    }
}
