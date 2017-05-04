package MW.trip;

import MW.exception.MaxLoadExceededException;
import MW.service.Car;
import MW.service.TripCostsCalculator;
import MW.exception.MaxPassengerExceededException;

public class Main{

    public static void main (String args[]) {
        Trip trip = new Trip(createMercedes(), 800);
        TripCostsCalculator calc = new TripCostsCalculator(trip);

        try {
            Voyager zanetka = new Voyager("Żanetka", 52.5, 50);
            Voyager marek = new Voyager("Marek", 74.3, 30);
            Voyager marcin = new Voyager("Marcin", 80.0, 30);
            Voyager agata = new Voyager("Agata", 53.0, 50);
            Voyager agata2 = new Voyager("Agata", 53.0, 10);


            trip.addVoyager(zanetka);
            trip.addVoyager(marek);
            trip.addVoyager(agata);
            trip.addVoyager(marcin);
            trip.addVoyager(agata2);
            calc.doCalculationsPerPassenger(trip);
            calc.doOverallCalculation(trip);
        } catch (MaxPassengerExceededException e) {
            System.out.println("Za dużo pasażerów! Maksymalna ilość miejsc wynosi "+ e.getMaxPassengers());
        } catch (MaxLoadExceededException e) {
            System.out.println("Za duże obciążenie! Maksymalne obciążenie wynosi " + e.getMaxLoad()+", a oczekiwana waga to " + e.getExpectedLoad());
        }
//        calc.doOverallCalculation(trip);


    }

    private static Car createMercedes() {
        Car car = new Car(7.5,5, 500.0);
        return car;
    }
}
