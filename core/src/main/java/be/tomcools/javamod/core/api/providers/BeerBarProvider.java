package be.tomcools.javamod.core.api.providers;

import be.tomcools.javamod.core.api.BeerBar;
import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.core.impl.BeerBarImpl;

import java.util.ServiceLoader;

public class BeerBarProvider {
    public static BeerBar provider() {
        return new BeerBarImpl(ServiceLoader.load(BeerRepository.class).findFirst()
                .orElseThrow(() ->  {
                    throw new RuntimeException("Missing BeerRepository implementation On Module Path");
                }));
    }
}
