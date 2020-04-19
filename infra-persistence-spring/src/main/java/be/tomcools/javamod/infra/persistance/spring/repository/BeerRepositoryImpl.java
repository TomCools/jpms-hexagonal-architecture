package be.tomcools.javamod.infra.persistance.spring.repository;

import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.core.domain.Beer;
import be.tomcools.javamod.infra.persistance.spring.config.StaticContextAccessor;
import be.tomcools.javamod.infra.persistance.spring.entity.BeerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class BeerRepositoryImpl implements BeerRepository {

    BeerRepositorySpring repo;

    @Autowired
    public BeerRepositoryImpl(BeerRepositorySpring repo) {
        this.repo = repo;
    }

    // This is called when using ServiceLoader
    public static BeerRepository provider() {
        return StaticContextAccessor.getBean(BeerRepository.class);
    }

    @Override
    public List<Beer> getAllBeers() {
        return repo.findAll().stream().map(BeerEntity::toDomain).collect(toList());
    }

    @Override
    public void addBeerToMenu(Beer newBeer) {
        repo.save(BeerEntity.fromDomain(newBeer));
    }
}
