package com.luisenricke.trackzilla.repository;

import com.luisenricke.trackzilla.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
