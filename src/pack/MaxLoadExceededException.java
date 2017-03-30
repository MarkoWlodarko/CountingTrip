package pack;


public class MaxLoadExceededException extends Throwable {
    private double maxLoad;

    private double expectedLoad;

    public MaxLoadExceededException(double maxLoad, double expectedLoad) {
        this.maxLoad = maxLoad;
        this.expectedLoad = expectedLoad;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getExpectedLoad() {
        return expectedLoad;
    }
}
