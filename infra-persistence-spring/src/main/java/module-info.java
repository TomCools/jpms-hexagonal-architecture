import be.tomcools.javamod.core.dependencies.BeerRepository;
import be.tomcools.javamod.infra.persistance.spring.repository.BeerRepositoryImpl;

open module infra.persistence.spring {
    requires core;
    provides BeerRepository with BeerRepositoryImpl;

    requires java.persistence;
    requires java.sql;

    requires java.annotation;

    requires java.xml.bind;
    requires net.bytebuddy;

    requires spring.context;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.jdbc;
    requires spring.orm;
    requires spring.tx;
    requires spring.jcl;

    /* Replaced by open module
    opens be.tomcools.javamod.infra.persistance.spring.repository to spring.core, spring.beans, spring.context;
    opens be.tomcools.javamod.infra.persistance.spring.config to spring.core, spring.beans, spring.context;
    opens be.tomcools.javamod.infra.persistance.spring.entity to org.hibernate.orm.core, spring.core, spring.beans;
    */
}