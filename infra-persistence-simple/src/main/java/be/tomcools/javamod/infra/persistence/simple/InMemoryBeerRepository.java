package be.tomcools.javamod.infra.persistence.simple;

import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.core.domain.Beer;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBeerRepository implements BeerRepository {
    private List<Beer> beerList = new ArrayList<>();

    @Override
    public List<Beer> getAllBeers() {
        System.out.println("Got beers from In Memory!");
        return beerList;
    }

    @Override
    public void addBeerToMenu(Beer newBeer) {
        beerList.add(newBeer);
    }
}
