package com.example.demo;

import lombok.Getter;

import java.util.UUID;

public class DemoException extends Throwable {
    @Getter private UUID id;
    
    public DemoException(final UUID id) {
        super();
        this.id = id;
    }
}
