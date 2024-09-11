package com.proyect.vortex.pruebavortex.application.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyect.vortex.pruebavortex.application.datatransferobject.TicketsDTO;
import com.proyect.vortex.pruebavortex.domain.entities.Tickets;

@Mapper(componentModel = "spring")
public interface TicketsMapper {

    Tickets toEntity(TicketsDTO ticketsDTO);
    TicketsDTO toDTO(Tickets tickets);

    List<Tickets> toEntity(List<TicketsDTO> ticketsDTO);
    List<TicketsDTO> toDTO(List<Tickets> tickets);

}
