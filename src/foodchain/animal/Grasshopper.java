package foodchain.animal;

import foodchain.consumer.PrimaryConsumer;

public class Grasshopper extends PrimaryConsumer {

    public Grasshopper(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public void move() {
        System.out.println("I am hopping");
    }
}
