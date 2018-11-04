package foodchain;

import foodchain.animal.Grasshopper;
import foodchain.animal.Hawk;
import foodchain.animal.Mouse;
import foodchain.animal.Python;
import foodchain.producer.Grass;
import foodchain.utility.FoodChainUtils;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FoodChain foodChain = new FoodChain(Arrays.asList(new Grass("Grass"),
                new Grasshopper("Grasshopper", 20),
                new Mouse("Mouse", 30),
                new Python("Python", 70),
                new Hawk("Hawk", 30)));

        if (FoodChainUtils.isFoodChain(foodChain)) {
            System.out.println("Your food chain is valid");
        } else {
            System.out.println("Your food chain is not valid");
        }

        if (FoodChainUtils.areNeighbours(
                new Mouse("Mickey", 3),
                new Python("Ochila", 30))) {
            System.out.println("This organisms are neighbors");
        } else {
            System.out.println("This organisms are not neighbors");
        }

        FoodChainUtils.traverse(foodChain);
    }
}
