import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.infra.persistence.simple.InMemoryBeerRepository;

open module infra.persistence.simple {
    requires core;
    provides BeerRepository with InMemoryBeerRepository;

}