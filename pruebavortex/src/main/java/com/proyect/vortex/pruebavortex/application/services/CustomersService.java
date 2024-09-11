package com.proyect.vortex.pruebavortex.application.services;

import java.util.List;

import com.proyect.vortex.pruebavortex.application.datatransferobject.CustomersDTO;

public interface CustomersService {

    CustomersDTO getCustomerById(int id) throws Exception;
    CustomersDTO createCustomer(CustomersDTO customersDTO);
    CustomersDTO updateCustomer(int id, CustomersDTO customersDTO) throws Exception;
    void deleteCustomer(int id) throws Exception;
    List<CustomersDTO> getAllCustomers();

}
