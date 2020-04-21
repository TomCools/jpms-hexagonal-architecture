package be.tomcools.javamod.app.javafx.controllers;

import be.tomcools.javamod.core.api.BeerBar;
import be.tomcools.javamod.core.domain.Beer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.stream.Collectors;

public class FXMLController {

    private BeerBar bar;

    public FXMLController(BeerBar bar) {
        this.bar = bar;
    }

    @FXML
    private TextArea textArea;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        bar.addBeerToMenu(new Beer("FxBeer",2.3));

        textArea.setText(bar.getBeerMenu().stream().map(b -> b.getName() + " " + b.getPrice()).collect(Collectors.joining()));
        textArea.setVisible(true);
    }
}