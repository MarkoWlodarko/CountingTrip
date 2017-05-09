package MW.trip;


import MW.service.InputExecutiveService;

public class Voyager {

    InputExecutiveService input = new InputExecutiveService();

    private int numOfVoyagers;

    private final String name;

    private final double weight;

    private final double bagWeight;

    public Voyager(){
        System.out.println("Podaj imię pasażera");
        name = input.input();

        System.out.println("Podaj wagę pasażera w kg");
        weight = Double.parseDouble(input.input());

        System.out.println("Podaj wagę bagażu pasażera w kg");
        bagWeight = Double.parseDouble(input.input());
    }

    public Voyager(String name, double weight, double bagWeight) {
        this.name = name;
        this.weight = weight;
        this.bagWeight = bagWeight;
    }

    public Voyager(String name, double weight) {
        bagWeight = 0;
        this.name = name;
        this.weight = weight;
    }

    public void NumOfVoygers(){
        numOfVoyagers = Integer.parseInt(input.input());
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

    public int getNumOfVoyagers() {
        return numOfVoyagers;
    }

    public double getOverallWeight(){
        return weight + bagWeight;
    }
}


