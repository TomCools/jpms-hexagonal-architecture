import be.tomcools.javamod.core.api.BeerBar;

open module app.web.spring {
    requires core;

    uses BeerBar;

    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;
    requires spring.web;
    requires spring.context;
    requires spring.jcl;

    requires com.fasterxml.classmate;
    // Below is for error: java.lang.IllegalArgumentException: No converter found for return value of type Arraylist
    requires com.fasterxml.jackson.databind;


    /*
    Replaced by opening module
    opens be.tomcools.javamod.app.web.spring to spring.core, spring.beans, spring.context;
    opens be.tomcools.javamod.app.web.spring.config to spring.core, spring.beans, spring.context;
    opens be.tomcools.javamod.app.web.spring.controller to spring.core, spring.beans, spring.web;
    */
}