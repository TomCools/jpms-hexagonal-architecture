package be.tomcools.javamod.app.web.spring.controller;

import be.tomcools.javamod.core.api.BeerBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/beers")
public class BeerController {

    @Autowired
    BeerBar beerBar;

    @GetMapping
    public List<BeerDto> getBeerMenu() {
        return beerBar.getBeerMenu().stream().map(BeerDto::from).collect(toList());
    }

    @PostMapping
    public void addBeertoMenu(@RequestBody BeerDto beerDto) {
        beerBar.addBeerToMenu(beerDto.toDomain());
    }
}
