package MW.trip;

import MW.exception.MaxLoadExceededException;
import MW.service.Car;
import MW.service.InputExecutiveService;
import MW.service.InputService;
import MW.service.TripCostsCalculator;
import MW.exception.MaxPassengerExceededException;

public class Main{

    public static void main (String args[]) {
        InputService input = new InputExecutiveService();
        Car mercedes = createMercedes(input);
        Trip trip = new Trip(mercedes, 800);
        TripCostsCalculator calc = new TripCostsCalculator();
        int numOfPassengers;

        try {
            System.out.println("Podaj ilość pasażerów udających się w podróż");
            numOfPassengers = Integer.parseInt(input.input());
            trip.willAllVoyagersGetIn(numOfPassengers);
            for (int i=0; i < numOfPassengers; i++){
                Voyager newPassenger = createPassenger(input, i);
                trip.addVoyager(newPassenger);
            }
            System.out.println("Całkowity koszt podróży wyniósł: " + calc.calcOverallCost(trip) + " Złotych");
            System.out.println("Koszt podróży na jedną osobę wyniósł: " + calc.calcCostPerPassenger(trip) + " Złotych");
        } catch (MaxPassengerExceededException e) {
            System.out.println("Za dużo pasażerów! Maksymalna ilość miejsc wynosi "+ e.getMaxPassengers());
        } catch (MaxLoadExceededException e) {
            System.out.println("Za duże obciążenie! Maksymalne obciążenie wynosi " + e.getMaxLoad()+", a oczekiwana waga to " + e.getExpectedLoad());
        }

    }

    private static Voyager createPassenger(InputService input, int i) {
        System.out.println("Podaj imię pasażera " + i);
        String name = input.input();

        System.out.println("Podaj wagę pasażera w kg");
        double weight = Double.parseDouble(input.input());

        System.out.println("Podaj wagę bagażu pasażera w kg");
        double bagWeight = Double.parseDouble(input.input());
        return new Voyager(name, weight, bagWeight);
    }

    private static Car createMercedes(InputService input) {
        System.out.println("Podaj spalanie pojazdu (zamaist przecinka użyj kropki)");
        double burning = Double.parseDouble(input.input());

        System.out.println("Podaj maksymalną ilość miejsc w pojeździe (cyfrą)");
        int maxPassengers = Integer.parseInt(input.input());

        System.out.println("Podaj maksymalne obciążenie pojazdu w kg");
        double maxLoad = Double.parseDouble(input.input());
        Car car = new Car(burning, maxPassengers, maxLoad);

        return car;
    }
}
