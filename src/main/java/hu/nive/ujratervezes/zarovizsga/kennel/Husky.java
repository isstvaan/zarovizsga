package hu.nive.ujratervezes.zarovizsga.kennel;

public class Husky extends Dog {
    public Husky(String name) {
        super(name);
    }

    @Override
    void feed() {
        super.happiness += 4;
    }

    @Override
    void play(int hours) {
        super.happiness += (hours * 3);
    }
}
