package foodchain.producer;

public class Cauliflower extends Producer {

    public Cauliflower(String name) {
        super(name);
    }

    @Override
    public void produce() {
        System.out.println("Hi, I am cauliflower and I am food");
    }
}
