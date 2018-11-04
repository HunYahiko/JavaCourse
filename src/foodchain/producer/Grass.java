package foodchain.producer;

public class Grass extends Producer {

    public Grass(String name) {
        super(name);
    }

    @Override
    public void produce() {
        System.out.println("Hi, I am green and I produce oxygen");
    }


}
