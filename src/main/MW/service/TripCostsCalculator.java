package MW.service;

import MW.trip.Trip;

public class TripCostsCalculator {

    private static final double FUEL_PRICE = 5.0;

    public double calcCostPerPassenger(Trip trip){
        double costs;
        costs = calcOverallCost(trip) / trip.countNumOfPassengers();
        return costs;
    }

    public double calcOverallCost(Trip trip) {
        double costs;
        costs = trip.getDistance() * costPerKilometer(trip) + trip.getFares();
        return costs;
    }

    private double costPerKilometer(Trip trip){
        double costPK = trip.calcFuelPer100Km() * FUEL_PRICE;
        return costPK;
    }
}
