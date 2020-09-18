package com.example.demo;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping("/")
    public DemoModel postGeometry(@RequestBody final Geometry<G2D> geometry) {
        return this.demoService.save(geometry);
    }

    @GetMapping("/{id}")
    public DemoModel getGeometry(@PathVariable final UUID id) throws DemoException {
        return this.demoService.get(id);
    }
}
