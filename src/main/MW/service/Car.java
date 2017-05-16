package MW.service;

public class Car {

    private final double burning;

    private final int maxPassengers;

    private final double maxLoad;

    public Car(double burning, int maxPassengers, double maxLoad) {
        this.burning = burning;
        this.maxPassengers = maxPassengers;
        this.maxLoad = maxLoad;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getBurning() {
        return burning;
    }

}
