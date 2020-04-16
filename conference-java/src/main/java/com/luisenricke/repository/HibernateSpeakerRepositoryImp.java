package com.luisenricke.repository;

import com.luisenricke.model.Speaker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("speakerRepository")
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
