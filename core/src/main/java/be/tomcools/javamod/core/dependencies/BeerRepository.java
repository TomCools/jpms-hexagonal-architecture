package be.tomcools.javamod.core.dependencies;

import be.tomcools.javamod.core.domain.Beer;

import java.util.List;

public interface BeerRepository {
    List<Beer> getAllBeers();

    void addBeerToMenu(Beer newBeer);
}
