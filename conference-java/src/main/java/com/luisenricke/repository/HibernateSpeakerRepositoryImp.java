package com.luisenricke.repository;

import com.luisenricke.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImp implements SpeakerRepository {

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Luis");
        speaker.setLastName("Villalobos");

        speakers.add(speaker);

        return speakers;
    }
}
