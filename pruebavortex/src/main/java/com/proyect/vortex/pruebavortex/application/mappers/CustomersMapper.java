package com.proyect.vortex.pruebavortex.application.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.proyect.vortex.pruebavortex.application.datatransferobject.CustomersDTO;
import com.proyect.vortex.pruebavortex.domain.entities.Customers;

@Mapper(componentModel = "spring")
public interface CustomersMapper {

    Customers toEntity(CustomersDTO customersDTO);
    CustomersDTO toDTO(Customers customers);
    
    List<Customers> toEntity(List<CustomersDTO> customersDTO);
    List<CustomersDTO> toDTO(List<Customers> customers);

}
