package MW.trip;

public class Voyager {

    private final String name;

    private final double weight;

    private final double bagWeight;

    public Voyager(String name, double weight, double bagWeight) {
        this.name = name;
        this.weight = weight;
        this.bagWeight = bagWeight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getBagWeight() {
        return bagWeight;
    }

    public double getOverallWeight(){
        return weight + bagWeight;
    }
}


