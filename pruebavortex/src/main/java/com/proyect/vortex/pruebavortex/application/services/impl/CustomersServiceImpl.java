package com.proyect.vortex.pruebavortex.application.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.vortex.pruebavortex.application.datatransferobject.CustomersDTO;
import com.proyect.vortex.pruebavortex.application.mappers.CustomersMapper;
import com.proyect.vortex.pruebavortex.application.services.ICustomersService;
import com.proyect.vortex.pruebavortex.domain.exceptions.NotFoundException;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.CustomersRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomersServiceImpl implements ICustomersService {

    private final CustomersRepository customersRepository;
    private final CustomersMapper customersMapper;

    @Autowired
    public CustomersServiceImpl(
            CustomersRepository customersRepository,
            CustomersMapper customersMapper) {
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
    public CustomersDTO updateCustomer(CustomersDTO customersDTO) throws Exception {
        var customer = customersRepository.findByEmail(customersDTO.getEmail()).orElseThrow(() -> new NotFoundException("Customer not found"));
        customer.setName(customersDTO.getName());
        customer.setEmail(customersDTO.getEmail());
        customer.setPhone(customersDTO.getPhone());
        customer.setIsActive(customersDTO.isActive());
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

    @Override
    public boolean disabledCustomer(int idCustomer) throws Exception {
        if (idCustomer < 1) throw new NotFoundException();
        CustomersDTO customers = getCustomerById(idCustomer);
        customers.setActive(!customers.isActive());
        customers = updateCustomer(customers);
        return customers.isActive();
    }

}
