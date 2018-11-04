package foodchain.consumer;

import foodchain.Organism;
import foodchain.animal.Animal;

public abstract class SecondaryConsumer extends Animal implements  Consumer {

    public SecondaryConsumer(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public boolean canEat(Organism organism) {
        return  organism instanceof PrimaryConsumer;
    }
}
