package com.proyect.vortex.pruebavortex.infrastructure.views;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.vortex.pruebavortex.application.services.ICustomersService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ICustomersService customersService;

    public CustomerController(
        ICustomersService customersService
    ) {
        this.customersService = customersService;
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<?> getById(@RequestParam("customerId") int customerId) {
        try {
            var customer = customersService.getCustomerById(customerId);
            if (customer != null)
                return ResponseEntity.ok(customer);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error consultando customer", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }
    
    
}
