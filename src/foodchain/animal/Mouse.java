package foodchain.animal;

import foodchain.consumer.SecondaryConsumer;

public class Mouse extends SecondaryConsumer {

    public Mouse(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public void move() {
        System.out.println("I am sneaking");
    }
}
