package com.proyect.vortex.pruebavortex.application.security.jwt;

import java.util.Collections;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyect.vortex.pruebavortex.domain.entities.Customers;
import com.proyect.vortex.pruebavortex.infrastructure.repositories.CustomersRepository;

@Service
public class CustomerDeteilsServiceImpl implements UserDetailsService {

    private final CustomersRepository customersRepository;

    
    public CustomerDeteilsServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customers customers = customersRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con email: " + username));
        return new User(customers.getEmail(), customers.getPassword(), Collections.emptyList());
    }
}
