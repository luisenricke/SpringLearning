package com.luisenricke.conferencedemo.repositories;

import com.luisenricke.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {

}
