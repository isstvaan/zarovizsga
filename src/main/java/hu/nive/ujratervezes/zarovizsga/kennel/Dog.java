package hu.nive.ujratervezes.zarovizsga.kennel;

public abstract class Dog {
    private final String name;
    protected int happiness = 0;

    public Dog(String name) {
        this.name = name;
    }

    abstract void feed();

    abstract void play(int hours);

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    @Override
    public String toString() {
        return name;
    }
}
