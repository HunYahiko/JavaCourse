package foodchain;

import java.util.LinkedList;
import java.util.List;

public class FoodChain {
    private List<Organism> chain = new LinkedList<>();

    public FoodChain(List<Organism> list) {
        this.chain = list;
    }

    public List<Organism> getChain() {
        return chain;
    }

    public void setChain(List<Organism> chain) {
        this.chain = chain;
    }

    public void addOrganism(Organism organism) {
        this.chain.add(organism);
    }

}
