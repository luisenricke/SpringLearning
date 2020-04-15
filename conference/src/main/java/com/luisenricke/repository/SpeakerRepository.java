package com.luisenricke.repository;

import com.luisenricke.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
