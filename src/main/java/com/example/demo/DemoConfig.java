package com.example.demo;

import org.geolatte.geom.json.GeolatteGeomModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.zalando.problem.jackson.ProblemModule;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class DemoConfig {
    @Bean
    public GeolatteGeomModule geolatteGeomModule() {
        return new GeolatteGeomModule();
    }

    @Bean
    public ProblemModule problemModule() {
        return new ProblemModule();
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("admin");
    }
}
