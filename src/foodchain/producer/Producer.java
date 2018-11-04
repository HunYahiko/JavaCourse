package foodchain.producer;

import foodchain.Organism;

public abstract class Producer implements Organism {
    private String name;

    public Producer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void produce() {
        System.out.println("I produce something");
    }

    @Override
    public boolean canEat(Organism organism) {
        return false;
    }
}
