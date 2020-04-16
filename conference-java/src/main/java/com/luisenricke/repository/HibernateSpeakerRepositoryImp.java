package com.luisenricke.repository;

import com.luisenricke.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImp implements SpeakerRepository {

    @Autowired
    private Calendar calendar;

    @Value("#{ T(java.lang.Math).random() *100}")
    private double random;

    @Override
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("Luis");
        speaker.setLastName("Villalobos");
        speaker.setSeed(random);

        System.out.println("Date: " + calendar.getTime());

        speakers.add(speaker);

        return speakers;
    }
}
