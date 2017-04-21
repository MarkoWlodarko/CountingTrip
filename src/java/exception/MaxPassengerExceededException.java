package java.exception;


public class MaxPassengerExceededException extends Exception {
    private int maxPassengers;

    private int expectedPassengersLoad;

    public MaxPassengerExceededException(int maxPassengers, int expectedPassengersLoad) {
        this.maxPassengers = maxPassengers;
        this.expectedPassengersLoad = expectedPassengersLoad;
        System.out.println("Za dużo pasażerów! Maksymalna ilość miejsc wynosi "+ getMaxPassengers());
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getExpectedPassengersLoad() {
        return expectedPassengersLoad;
    }
}
