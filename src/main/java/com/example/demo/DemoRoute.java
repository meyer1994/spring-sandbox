package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DemoRoute extends RouteBuilder {
    private static final String MODEL = DemoModel.class.getName();

    @Override
    public void configure() {
        final String query = String.format("SELECT o FROM %s o WHERE status = 'NOT_PUBLISHED'", MODEL);
        fromF("jpa://%s?consumeDelete=false&delay=5000&query=%s", MODEL, query)
                .log("Publishing ${body.id}")
                .log("Published ${body.id}");
    }
}
