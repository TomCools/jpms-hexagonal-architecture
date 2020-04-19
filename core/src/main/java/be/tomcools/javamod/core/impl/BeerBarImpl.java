package be.tomcools.javamod.core.impl;

import be.tomcools.javamod.core.api.BeerBar;
import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.core.domain.Beer;

import java.util.List;
import java.util.ServiceLoader;

public class BeerBarImpl implements BeerBar {

    private BeerRepository repository;

    public BeerBarImpl(BeerRepository repository) {
        this.repository = repository;
    }

    public static BeerBar provider() {
        return new BeerBarImpl(ServiceLoader.load(BeerRepository.class).findFirst()
                .orElseThrow(() ->  {
                    throw new RuntimeException("Missing BeerRepository implementation On Module Path");
                }));
    }

    @Override
    public List<Beer> getBeerMenu() {
        return repository.getAllBeers();
    }

    @Override
    public void addBeerToMenu(Beer newBeer) {
        repository.addBeerToMenu(newBeer);
    }
}
