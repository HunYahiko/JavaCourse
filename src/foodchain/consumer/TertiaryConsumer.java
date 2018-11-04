package foodchain.consumer;

import foodchain.Organism;
import foodchain.animal.Animal;

public abstract class TertiaryConsumer extends Animal implements Consumer {

    public TertiaryConsumer(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public boolean canEat(Organism organism) {
        return organism instanceof SecondaryConsumer;
    }
}
