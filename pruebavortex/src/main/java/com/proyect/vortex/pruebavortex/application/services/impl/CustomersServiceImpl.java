package com.proyect.vortex.pruebavortex.application.services.impl;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.vortex.pruebavortex.application.datatransferobject.CustomersDTO;
import com.proyect.vortex.pruebavortex.application.mappers.CustomersMapper;
import com.proyect.vortex.pruebavortex.application.services.CustomersService;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.CustomersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomersServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;
    private final CustomersMapper customersMapper;

    // @Autowired
    public CustomersServiceImpl(
            CustomersRepository customersRepository,
            CustomersMapper customersMapper) {
        super();
        this.customersRepository = customersRepository;
        this.customersMapper = customersMapper;
    }

    @Override
    public CustomersDTO getCustomerById(int id) throws Exception {
        var customer = customersRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
        return customersMapper.toDTO(customer);
    }

    @Override
    public CustomersDTO createCustomer(CustomersDTO customersDTO) {
        var customerEntity = customersMapper.toEntity(customersDTO);
        customerEntity = customersRepository.save(customerEntity);
        return customersMapper.toDTO(customerEntity);
    }

    @Override
    public CustomersDTO updateCustomer(int id, CustomersDTO customersDTO) throws Exception {
        var customer = customersRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));

        customer.setName(customersDTO.getName());
        customer.setEmail(customersDTO.getEmail());

        customer = customersRepository.save(customer);
        return customersMapper.toDTO(customer);
    }

    @Override
    public void deleteCustomer(int id) throws Exception {
        var customer = customersRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer not found"));
        customersRepository.delete(customer);
    }

    @Override
    public List<CustomersDTO> getAllCustomers() {
        var customers = customersRepository.findAll();
        return customersMapper.toDTO(customers);
    }

}
