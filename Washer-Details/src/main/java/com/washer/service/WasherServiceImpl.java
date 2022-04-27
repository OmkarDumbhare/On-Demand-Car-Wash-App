package com.washer.service;

import com.washer.model.Washer;
import com.washer.repository.WasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WasherServiceImpl implements WasherService{

    @Autowired
    private WasherRepository washerRepository;

    @Override
    public Washer addWashers(Washer washer) {

        Washer washers = new Washer();
        washers.setRole("Washer");
        return washerRepository.save(washer);
    }

    @Override
    public Washer findByName(String name) {

        Washer washer = washerRepository.findAll().stream().filter(a->a.getUsername()
                        .equalsIgnoreCase(name)).findAny().orElseThrow(null);
        return washer;
    }

    @Override
    public List<Washer> getAllWashers() {
        return washerRepository.findAll();
    }

    @Override
    public Washer updateWasher(Washer washer) {
        return washerRepository.save(washer);
    }


}
