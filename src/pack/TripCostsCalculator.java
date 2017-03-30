package pack;

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
}
