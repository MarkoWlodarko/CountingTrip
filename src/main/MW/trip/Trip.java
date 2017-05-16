package MW.trip;

import MW.exception.MaxLoadExceededException;
import MW.service.Car;
import MW.exception.MaxPassengerExceededException;
import java.util.HashSet;
import java.util.Set;

public class Trip {

    private Set<Voyager> voyagers = new HashSet<>();

    private Car car;


    private double distance;

    private double fares = 0;

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

    public void willAllVoyagersGetIn(int numOfVoyagers) throws MaxPassengerExceededException{
        if(numOfVoyagers > car.getMaxPassengers()) {
            throw new MaxPassengerExceededException(car.getMaxPassengers(),numOfVoyagers);
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

    public double calcFuelPer100Km(){
        return car.getBurning() / 100;
    }

    public void addFare(double fares){
        this.fares += fares;
    }

    public double getFares() {
        return fares;
    }
}
