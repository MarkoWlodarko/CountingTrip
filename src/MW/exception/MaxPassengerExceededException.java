package MW.exception;


public class MaxPassengerExceededException extends Exception {
    private int maxPassengers;

    private int expectedPassengersLoad;

    public MaxPassengerExceededException(int maxPassengers, int expectedPassengersLoad) {
        this.maxPassengers = maxPassengers;
        this.expectedPassengersLoad = expectedPassengersLoad;

    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getExpectedPassengersLoad() {
        return expectedPassengersLoad;
    }
}
