package hu.nive.ujratervezes.zarovizsga.kennel;

public class Beagle extends Dog {
    public Beagle(String name) {
        super(name);
    }

    @Override
    void feed() {
        super.happiness += 2;
    }

    @Override
    void play(int hours) {
        super.happiness += (hours * 2);
    }
}
