package be.tomcools.javamod.core.api;

import be.tomcools.javamod.core.domain.Beer;

import java.util.List;

public interface BeerBar {
    List<Beer> getBeerMenu();

    void addBeerToMenu(Beer newBeer);
}
