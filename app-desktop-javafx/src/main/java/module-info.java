import be.tomcools.javamod.core.api.BeerBar;

module app.desktop.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires core;

    uses BeerBar;

    // Needed for FXML, so it can inject the fields
    opens be.tomcools.javamod.app.javafx.controllers to javafx.fxml;
    exports be.tomcools.javamod.app.javafx;
}