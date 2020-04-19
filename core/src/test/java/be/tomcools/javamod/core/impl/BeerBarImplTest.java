package be.tomcools.javamod.core.impl;

import be.tomcools.javamod.core.dependencies.BeerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BeerBarImplTest {
    @Test
    public void init() {
        BeerBarImpl bar = new BeerBarImpl(Mockito.mock(BeerRepository.class));

        //throw new RuntimeException("FAIL");
        //bar.getBeerMenu();
    }
}