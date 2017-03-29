package pack;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Marek on 2017-03-18.
 */
public class Trip {

    private Set<Voyager> voyagers = new HashSet<>();

    private Car car;

    public static final double FUEL_PRICE = 4.56;

    private double distance;

    private double fares = 0;

    public void setDistance(double distance){
        this.distance = distance;
    }

    public Trip(Car car, double distance) {
        this.car = car;
        this.distance = distance;
    }

    public void addVoyager(Voyager voyager) throws MaxPassengerExceededException, MaxLoadExceededException {
        if(voyagers.size() >= car.getMaxPassengers()) {
            throw new MaxPassengerExceededException(car.getMaxPassengers(),voyagers.size());
        } else if(countExpectedLoad(voyager) > car.getMaxLoad()) {
            throw new MaxLoadExceededException(car.getMaxLoad(),countExpectedLoad(voyager));
        } else{
            voyagers.add(voyager);
        }
    }

    public Integer countNumOfPassengers(){
        return voyagers.size();
    }


    private double countExpectedLoad(Voyager voyager) {
        return countCurrentLoad() + voyager.getOverallWeight();
    }

    private double countCurrentLoad(){
        double sum = 0;
        for (Voyager voyager : voyagers) {
            sum += voyager.getOverallWeight();
        }
        return sum;
    }

    public double getDistance() {
        return distance;
    }

    public void doOverallCalculation(Trip trip){
        TripCostsCalculator calculation = new TripCostsCalculator(trip);
        System.out.println("Całkowity koszt podróży wyniósł: " + calculation.calcOverallCost() + " Złotych");
    }

    public void doCalculationsPerPassenger(Trip trip){
        TripCostsCalculator calculation = new TripCostsCalculator(trip);
        System.out.println("Koszt podróży na jedną osobę wyniósł: " + calculation.calcCostPerPassenger() + " Złotych");
    }


    public double costPerKilometer(){
        double costPK = car.getBurning() / 100 * FUEL_PRICE;
        return costPK;
    }

    public void addFare(double fares){
        this.fares += fares;
    }

    public double getFares() {
        return fares;
    }
}
