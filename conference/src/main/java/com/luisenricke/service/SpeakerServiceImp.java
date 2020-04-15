package com.luisenricke.service;

import com.luisenricke.model.Speaker;
import com.luisenricke.repository.HibernateSpeakerRepositoryImp;
import com.luisenricke.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImp implements SpeakerService {

    private SpeakerRepository repository = new HibernateSpeakerRepositoryImp();

    @Override
    public List<Speaker> findAll() {
        return  repository.findAll();
    }

}
