package foodchain.utility;

import foodchain.FoodChain;
import foodchain.Organism;
import foodchain.consumer.Consumer;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class FoodChainUtils {

    public static boolean isFoodChain(FoodChain foodChain) {
        AtomicBoolean isFoodChain = new AtomicBoolean(true);
        IntStream.range(0, foodChain.getChain().size())
                .map(index -> foodChain.getChain().size() - index - 1)
                .filter(index -> index != 0)
                .forEach(index -> {
                    if (!foodChain.getChain()
                            .get(index)
                            .canEat(foodChain.getChain().get(index - 1))) {
                        isFoodChain.set(false);
                    }
                });
        return isFoodChain.get();
    }

    public static boolean areNeighbours(Organism organism1, Organism organism2) {

        if (organism1.canEat(organism2) || organism2.canEat(organism1)) {
            return true;
        } else {
            return false;
        }
    }

    public static void traverse(FoodChain foodChain) {
        IntStream.range(0, foodChain.getChain().size())
                .forEach(index -> {
                    System.out.print(foodChain.getChain().get(index).getName());
                    if (index < foodChain.getChain().size() - 1) {
                        System.out.print(" <- ");
                    }
                });
    }
}
