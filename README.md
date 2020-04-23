# Example Project for Hexagonal Architecture with the Java Module System.

> This README is work in progress.

## Components

### Core

The core module is the center of the application. 
It contains no dependencies on any framework but does contain our business logic.

It does show how the interfaces are exported and how it loads dependencies with the ServiceLoader.

### Application - Components
#### app-console-simple

A simple console application. It doesn't do much functionality wise.
It's purpose in this repository is to show how you can use **lombok** with JPMS.

Lombok requires 2 things to work:

- You need to require it in your module with **"requires static"**
- You need to configure your maven project to do the annotation-processing in a JPMS world. For more info on that, check [this issue on github](https://github.com/rzwitserloot/lombok/issues/1723).

#### app-desktop-javafx

A JavaFX application with FXML (openjfx)

- Required us to open our Controller to javafx.fxml;

#### app-web-spring

A Spring Boot application, with a simple RestController to invoke actions on the core module.

### Infrastructure - Components
#### infra-persistence-simple

A simple in-memory way of saving objects, using an in memory ArrayList. Nothing special.

#### infra-persistence-spring

A Spring style persistence layer, using spring-boot-starter-data-jpa and an H2 database.
It shows how to set up the repositories when it is separated from the main Spring Boot application by modules.

## Build/Run

### Requirements

- Java 9+
- Maven

### With JPMS

Setup your combination of modules you want to run in the pom.xml file of the **bundler project** and run
```bash
# Build solution (in root)
mvn verify
```

At this time, not all modules will work together. This is mainly because the Spring Persistence still depends on a Spring application context.

**Module Compatibility**

|   Application  | Infrastructure-Persistance |
|:--------------:|:--------------------------:|
|        *       |   infa-persistence-simple  |
| app-web-spring |  infra-persistence-spring  |

---


All commands assume you are at the root of the project
```bash

# Running with Spring Web as Application Layer (app-web-spring)
# --add-modules java.instrument needed for Spring
java --add-modules java.instrument -p bundler/target/modules/. --module app.web.spring/be.tomcools.javamod.app.web.spring.WebApplication

# Running with Simple Console as Application Layer (app-console-simple)
java -p bundler/target/modules/. --module app.console.simple/be.tomcools.javamod.app.console.ConsoleStarter

# Running with Spring Web as Application Layer (app-desktop-javafx)
java -p bundler/target/modules/. --module app.desktop.javafx/be.tomcools.javamod.app.javafx.FxStarter
```
