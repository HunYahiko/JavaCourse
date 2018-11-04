package foodchain.animal;

import foodchain.consumer.QuaternaryConsumer;

public class Hawk extends QuaternaryConsumer {

    public Hawk(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public void move() {
        System.out.println("I am flying");
    }
}
