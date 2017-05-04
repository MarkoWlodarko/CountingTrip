package MW.service;

import MW.trip.Trip;

public class TripCostsCalculator {

    Trip trip = null;

    public TripCostsCalculator(Trip trip) {
        this.trip = trip;
    }

    public double calcCostPerPassenger(){
        double costs;
        costs = calcOverallCost() / trip.countNumOfPassengers();
        return costs;
    }


    public double calcOverallCost() {
        double costs;
        costs = trip.getDistance() * trip.costPerKilometer() + trip.getFares();
        return costs;
    }
    public void doOverallCalculation(Trip trip){
        System.out.println("Całkowity koszt podróży wyniósł: " + calcOverallCost() + " Złotych");
    }

    public void doCalculationsPerPassenger(Trip trip){
        System.out.println("Koszt podróży na jedną osobę wyniósł: " + calcCostPerPassenger() + " Złotych");
    }

}
