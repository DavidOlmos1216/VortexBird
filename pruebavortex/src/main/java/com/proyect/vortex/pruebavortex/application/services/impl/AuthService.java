package com.proyect.vortex.pruebavortex.application.services.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyect.vortex.pruebavortex.application.datatransferobject.CustomersDTO;
import com.proyect.vortex.pruebavortex.application.datatransferobject.RegistrationCustomerDTO;
import com.proyect.vortex.pruebavortex.application.mappers.CustomersMapper;
import com.proyect.vortex.pruebavortex.application.security.jwt.CustomerDeteilsServiceImpl;
import com.proyect.vortex.pruebavortex.application.services.ICustomerSecurity;
import com.proyect.vortex.pruebavortex.domain.entities.Customers;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.CustomersRepository;

@Service
public class AuthService implements ICustomerSecurity {

    private final CustomerDeteilsServiceImpl customersServiceImpl;
    private final CustomersRepository customersRepository;
    private final CustomersMapper customersMapper;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public AuthService(CustomerDeteilsServiceImpl customersServiceImpl, CustomersRepository customersRepository,
            CustomersMapper customersMapper, PasswordEncoder passwordEncoder) {
        this.customersServiceImpl = customersServiceImpl;
        this.customersRepository = customersRepository;
        this.customersMapper = customersMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return customersServiceImpl.loadUserByUsername(username);
    }

    @Override
    public RegistrationCustomerDTO registrationCustomer(RegistrationCustomerDTO registrationCustomerDTO) {
        if (customersRepository.existsByEmail(registrationCustomerDTO.getEmail()))
            return null;
        CustomersDTO customersDTO = new CustomersDTO();
        BeanUtils.copyProperties(registrationCustomerDTO, customersDTO);
        String encodedPassword = passwordEncoder.encode(registrationCustomerDTO.getPassword());
        customersDTO.setPassword(encodedPassword);
        Customers customers = customersMapper.toEntity(customersDTO);
        customers = customersRepository.save(customers);
        return customersMapper.toDTO(customers);
    }

    @Override
    public String loginCustomer(String email) {
        var userDetails = loadUserByUsername(email);
        return userDetails.getUsername();
    }

}
