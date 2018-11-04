package foodchain.animal;

public abstract class Animal {
    private String name;
    private Integer lifeSpan;

    public Animal(String name, Integer lifeSpan) {
        this.name = name;
        this.lifeSpan = lifeSpan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(Integer lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public void move() {
        System.out.println("I am moving");
    }
}
