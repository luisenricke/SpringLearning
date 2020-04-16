package com.luisenricke.service;

import com.luisenricke.model.Speaker;
import com.luisenricke.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SpeakerServiceImp implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImp() {
        System.out.println("SpeakerService no args constructor");
    }

    public SpeakerServiceImp(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerService repository constructor");
        this.repository = speakerRepository;
    }

    @Autowired
    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerService setter");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
