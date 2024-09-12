package com.proyect.vortex.pruebavortex.application.services;

import java.util.List;

import com.proyect.vortex.pruebavortex.application.datatransferobject.TicketsDTO;

public interface ITicketsService {

    TicketsDTO createTicket(TicketsDTO ticketsDTO);
    void deleteTicket(int id) throws Exception;
    List<TicketsDTO> getTicketsByCustomer(int customerId);
}
