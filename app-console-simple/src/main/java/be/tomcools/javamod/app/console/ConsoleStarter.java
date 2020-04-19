package be.tomcools.javamod.app.console;

import be.tomcools.javamod.core.api.BeerBar;
import be.tomcools.javamod.core.domain.Beer;

import java.util.ServiceLoader;

public class ConsoleStarter {
    public static void main(String[] args) {
        ServiceLoader.load(BeerBar.class).findFirst()
                .ifPresent(ConsoleStarter::execute);
    }

    private static void execute(BeerBar b) {
        b.addBeerToMenu(new Beer("Example Beer", 3.8));

        BeerBarDto beerList = new BeerBarDto(b.getBeerMenu());
        System.out.println(beerList);
    }
}
