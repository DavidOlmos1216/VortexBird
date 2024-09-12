package com.proyect.vortex.pruebavortex.application.services;

import org.springframework.security.core.userdetails.UserDetails;

import com.proyect.vortex.pruebavortex.application.datatransferobject.LoginCustomerDTO;
import com.proyect.vortex.pruebavortex.application.datatransferobject.RegistrationCustomerDTO;

public interface ICustomerSecurity {
    UserDetails loadUserByUsername(String username);
    RegistrationCustomerDTO registrationCustomer(RegistrationCustomerDTO registrationCustomerDTO);
    String loginCustomer(String email);
}
