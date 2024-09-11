package com.proyect.vortex.pruebavortex.application.services.impl;

import com.proyect.vortex.pruebavortex.application.datatransferobject.TicketsDTO;
import com.proyect.vortex.pruebavortex.application.mappers.TicketsMapper;
import com.proyect.vortex.pruebavortex.application.services.TicketsService;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.TicketsRepository;


import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TicketsServiceImpl implements TicketsService {

    private final TicketsRepository ticketsRepository;
    private final TicketsMapper ticketsMapper;

    public TicketsServiceImpl(
            TicketsRepository ticketsRepository,
            TicketsMapper ticketsMapper) {
        super();
        this.ticketsMapper = ticketsMapper;
        this.ticketsRepository = ticketsRepository;
    }

    @Override
    public TicketsDTO createTicket(TicketsDTO ticketsDTO) {
        var ticketEntity = ticketsMapper.toEntity(ticketsDTO);
        ticketEntity = ticketsRepository.save(ticketEntity);
        return ticketsMapper.toDTO(ticketEntity);
    }

    @Override
    public void deleteTicket(int id) throws Exception {
        var ticket = ticketsRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket not found"));
        ticketsRepository.delete(ticket);
    }

    
}
