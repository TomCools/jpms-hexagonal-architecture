import be.tomcools.javamod.core.api.BeerBar;

module app.console.simple {
    requires core;

    requires static lombok; // required for compilation, optional at runtime

    uses BeerBar;
}