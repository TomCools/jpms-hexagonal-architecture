package be.tomcools.javamod.app.web.spring.config;

import be.tomcools.javamod.core.api.BeerBar;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

import java.util.ServiceLoader;

@Configuration
public class ConfigurationSetup {

    @Bean
    BeerBar setupBeerBar() {
        return ServiceLoader.load(BeerBar.class).findFirst()
                .orElseThrow(() -> new RuntimeException("Couldn't find instance of BeerBar. No module provided it."));
    }
}
