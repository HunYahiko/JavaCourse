package foodchain.consumer;

import foodchain.Organism;
import foodchain.animal.Animal;
import foodchain.producer.Producer;

public abstract class PrimaryConsumer extends Animal implements Consumer {

    public PrimaryConsumer(String name, Integer lifeSpan) {
        super(name, lifeSpan);
    }

    @Override
    public boolean canEat(Organism organism) {
        return organism instanceof Producer;
    }
}
