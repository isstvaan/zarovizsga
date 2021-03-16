package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    private final List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void feedAll() {
        for (Dog item : dogs) {
            item.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog item : dogs) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        throw new IllegalArgumentException("Dog not found: " + name);
    }

    public void playWith(String name, int hour) {
        Dog foundedDog = findByName(name);
        if (foundedDog != null) {
            foundedDog.play(hour);
        }
    }

    public List<String> getHappyDogNames(int happinessValue) {
        List<String> happyDogs = new ArrayList<>();
        for (Dog item : dogs) {
            if (item.getHappiness() > happinessValue) {
                happyDogs.add(item.getName());
            }
        }
        return happyDogs;
    }
}
