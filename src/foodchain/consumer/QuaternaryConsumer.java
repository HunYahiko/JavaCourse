package foodchain.consumer;

import foodchain.Organism;
import foodchain.animal.Animal;

public abstract class QuaternaryConsumer extends Animal implements Consumer {

    public QuaternaryConsumer(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public boolean canEat(Organism organism) {
        return organism instanceof TertiaryConsumer;
    }
}
