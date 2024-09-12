package com.proyect.vortex.pruebavortex.application.services.impl;

import com.proyect.vortex.pruebavortex.application.datatransferobject.TicketsDTO;
import com.proyect.vortex.pruebavortex.application.mappers.TicketsMapper;
import com.proyect.vortex.pruebavortex.application.services.IEmailService;
import com.proyect.vortex.pruebavortex.application.services.ITicketsService;
import com.proyect.vortex.pruebavortex.domain.entities.Tickets;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.TicketsRepository;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class TicketsServiceImpl implements ITicketsService {

    private final TicketsRepository ticketsRepository;
    private final TicketsMapper ticketsMapper;
    private final IEmailService emailService;

    public TicketsServiceImpl(
            TicketsRepository ticketsRepository,
            TicketsMapper ticketsMapper,
            IEmailService emailService) {
        super();
        this.ticketsMapper = ticketsMapper;
        this.ticketsRepository = ticketsRepository;
        this.emailService = emailService;
    }

    @Override
    public TicketsDTO createTicket(TicketsDTO ticketsDTO) {
        var ticketEntity = ticketsMapper.toEntity(ticketsDTO);
        ticketEntity = ticketsRepository.save(ticketEntity);
        emailService.sendEmail(ticketsDTO.getCustomersDTO().getEmail(), "Compra de tiqueted para peliculas", "!!Felicidades has comprado un tiquetes para una pelicula!!");
        return ticketsMapper.toDTO(ticketEntity);
    }

    @Override
    public void deleteTicket(int id) throws Exception {
        var ticket = ticketsRepository.findById(id).orElseThrow(() -> new NotFoundException("Ticket not found"));
        ticketsRepository.delete(ticket);
    }

    @Override
    public List<TicketsDTO> getTicketsByCustomer(int customerId) {
        if (customerId < 1) Collections.emptyList();
        List<Tickets> tokects = ticketsRepository.findAllByCustomerId(customerId).orElse(Collections.emptyList());
        return ticketsMapper.toDTO(tokects);
    }

    
}
