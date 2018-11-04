package foodchain.animal;

import foodchain.consumer.SecondaryConsumer;

public class Frog extends SecondaryConsumer {

    public Frog(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public void move() {
        System.out.println("I am jumping");
    }
}
