package be.tomcools.javamod.core.impl;

import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.core.domain.Beer;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BeerBarImplTest {

    BeerRepository repo = mock(BeerRepository.class);

    BeerBarImpl sut = new BeerBarImpl(repo);

    @Test
    public void simpleShowcaseTest() {
        sut.addBeerToMenu(new Beer("TestBeer", 2.3));

        verify(repo).addBeerToMenu(any());
    }
}