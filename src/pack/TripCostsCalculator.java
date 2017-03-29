package pack;

/**
 * Created by Marek on 2017-03-22.
 */
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
