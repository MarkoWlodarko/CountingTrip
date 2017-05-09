package MW.service;

public class Car {

    InputExecutiveService input = new InputExecutiveService();

    private final double burning;

    private final int maxPassengers;

    private final double maxLoad;

    public Car() {
        System.out.println("Podaj spalanie pojazdu (zamaist przecinka użyj kropki)");
        burning = Double.parseDouble(input.input());

        System.out.println("Podaj maksymalną ilość miejsc w pojeździe (cyfrą)");
        maxPassengers = Integer.parseInt(input.input());

        System.out.println("Podaj maksymalne obciążenie pojazdu w kg");
        maxLoad = Double.parseDouble(input.input());
    }

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
