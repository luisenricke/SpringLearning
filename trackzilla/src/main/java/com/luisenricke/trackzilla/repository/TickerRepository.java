package com.luisenricke.trackzilla.repository;

import com.luisenricke.trackzilla.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TickerRepository extends CrudRepository<Ticket, Long> {
}
