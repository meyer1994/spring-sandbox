package com.example.demo;

import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public DemoModel save(final Geometry<G2D> geometry) {
        final DemoModel demoModel = new DemoModel();
        demoModel.setGeometry(geometry);
        return this.demoRepository.save(demoModel);
    }

    public DemoModel get(final UUID id) throws DemoException {
        return this.demoRepository.findById(id).orElseThrow(() -> new DemoException(id));
    }
}
