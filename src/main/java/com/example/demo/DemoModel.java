package com.example.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.camel.component.jpa.Consumed;
import org.apache.camel.component.jpa.PreConsumed;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;

import javax.persistence.*;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@Table
@Entity
public class DemoModel extends DemoAudit<String> {
    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "uuid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private Geometry<G2D> geometry;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.NOT_PUBLISHED;
    
    public static enum Status {
        NOT_PUBLISHED,
        PUBLISHED,
        PUBLISHING,
    }
    
    @PreConsumed
    public void preConsumed() {
        this.status = Status.PUBLISHING;
    }

    @Consumed
    public void consumed() {
        this.status = Status.PUBLISHED;
    }
}
