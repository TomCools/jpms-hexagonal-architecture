package be.tomcools.javamod.infra.persistance.spring.entity;

import be.tomcools.javamod.core.domain.Beer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class BeerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    public static BeerEntity fromDomain(Beer newBeer) {
        BeerEntity beerEntity = new BeerEntity();
        beerEntity.setName(newBeer.getName());
        beerEntity.setPrice(newBeer.getPrice());
        return beerEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Beer toDomain() {
        return new Beer(name, price);
    }
}
