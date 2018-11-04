package foodchain.animal;

import foodchain.consumer.TertiaryConsumer;

public class Python extends TertiaryConsumer {

    public Python(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public void move() {
        System.out.println("I am slithering");
    }
}
