package be.tomcools.javamod.core.domain;

public class Beer {
    private final String name;
    private final Double price;

    public Beer(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
