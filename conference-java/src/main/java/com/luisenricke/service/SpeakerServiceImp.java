package com.luisenricke.service;

import com.luisenricke.model.Speaker;
import com.luisenricke.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
//@Scope(BeanDefinition.SCOPE_SINGLETON)
public class SpeakerServiceImp implements SpeakerService {

    private SpeakerRepository repository;

    public SpeakerServiceImp() {
        System.out.println("SpeakerService no args constructor");
    }

    @Autowired
    public SpeakerServiceImp(SpeakerRepository speakerRepository) {
        System.out.println("SpeakerService repository constructor");
        this.repository = speakerRepository;
    }

    @PostConstruct
    private void initialize(){
        System.out.println("Called after the constructors");
    }

    public void setRepository(SpeakerRepository repository) {
        System.out.println("SpeakerService setter");
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll() {
        return repository.findAll();
    }
}
