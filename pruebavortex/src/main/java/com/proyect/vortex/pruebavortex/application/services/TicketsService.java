package com.proyect.vortex.pruebavortex.application.services;

import java.util.List;

import com.proyect.vortex.pruebavortex.application.datatransferobject.TicketsDTO;

public interface TicketsService {

    TicketsDTO createTicket(TicketsDTO ticketsDTO);
    void deleteTicket(int id) throws Exception;
}
