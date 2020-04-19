package be.tomcools.javamod.app.console;

import be.tomcools.javamod.core.domain.Beer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BeerBarDto {

    private final List<Beer> beerList;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("Available Beers: \n");

        for (Beer beer : beerList) {
            builder.append(beer.getName());
            builder.append(" at ");
            builder.append(beer.getPrice());
        }

        return builder.toString();
    }
}
