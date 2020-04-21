import be.tomcools.javamod.core.api.providers.BeerBarProvider;

module core {
    exports be.tomcools.javamod.core.domain;
    exports be.tomcools.javamod.core.api;
    exports be.tomcools.javamod.core.dependencies;

    uses be.tomcools.javamod.core.dependencies.BeerRepository;

    provides be.tomcools.javamod.core.api.BeerBar with BeerBarProvider;
}