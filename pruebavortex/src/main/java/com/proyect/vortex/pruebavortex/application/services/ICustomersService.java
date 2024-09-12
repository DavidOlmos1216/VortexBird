package com.proyect.vortex.pruebavortex.application.services;

import java.util.List;

import com.proyect.vortex.pruebavortex.application.datatransferobject.CustomersDTO;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;

public interface ICustomersService {

    CustomersDTO getCustomerById(int id) throws Exception;
    CustomersDTO createCustomer(CustomersDTO customersDTO);
    CustomersDTO updateCustomer(CustomersDTO customersDTO) throws Exception;
    void deleteCustomer(int id) throws Exception;
    List<CustomersDTO> getAllCustomers();
    boolean disabledCustomer(int idCustomer)  throws Exception;

}
