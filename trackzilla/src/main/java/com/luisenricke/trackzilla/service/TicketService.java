package com.luisenricke.trackzilla.service;

import com.luisenricke.trackzilla.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}
