package be.tomcools.javamod.app.web.spring.controller;

import be.tomcools.javamod.core.domain.Beer;

public class BeerDto {
    private String name;
    private Double price;

    public BeerDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public BeerDto() {
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Beer toDomain() {
        return new Beer(getName(), getPrice());
    }

    public static BeerDto from(Beer domain) {
        return new BeerDto(domain.getName(), domain.getPrice());
    }

}
