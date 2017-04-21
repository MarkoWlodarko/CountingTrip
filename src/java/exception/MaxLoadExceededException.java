package java.exception;


public class MaxLoadExceededException extends Throwable {
    private double maxLoad;

    private double expectedLoad;

    public MaxLoadExceededException(double maxLoad, double expectedLoad) {
        this.maxLoad = maxLoad;
        this.expectedLoad = expectedLoad;
        System.out.println("Za duże obciążenie! Maksymalne obciążenie wynosi "+getMaxLoad()+ ", a oczekiwana waga to " + getExpectedLoad());
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getExpectedLoad() {
        return expectedLoad;
    }
}
