package com.luisenricke.service;

import com.luisenricke.model.Speaker;
import com.luisenricke.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImp implements SpeakerService {

    private SpeakerRepository repository;

    @Override
    public List<Speaker> findAll() {
        return  repository.findAll();
    }

    public void setSpeakerRepository(SpeakerRepository repository) {
        this.repository = repository;
    }
}
