package pack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reynev on 3/20/17.
 */
public class Car {

    private final double burning;

    private final int maxPassengers;

    private final double maxLoad;

    @Deprecated
    public Car(int maxPassengers, double maxLoad) {
        burning = 8;
        this.maxPassengers = maxPassengers;
        this.maxLoad = maxLoad;
    }

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
