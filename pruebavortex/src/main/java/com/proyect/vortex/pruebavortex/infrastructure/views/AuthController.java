package com.proyect.vortex.pruebavortex.infrastructure.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.vortex.pruebavortex.application.datatransferobject.LoginCustomerDTO;
import com.proyect.vortex.pruebavortex.application.datatransferobject.LoginResponseDTO;
import com.proyect.vortex.pruebavortex.application.datatransferobject.RegistrationCustomerDTO;
import com.proyect.vortex.pruebavortex.application.services.ICustomerSecurity;
import com.proyect.vortex.pruebavortex.domain.commons.utils.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping()
public class AuthController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private final ICustomerSecurity customerSecurity;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(ICustomerSecurity customerSecurity, AuthenticationManager authenticationManager,
            JwtUtil jwtUtil) {
        this.customerSecurity = customerSecurity;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody @Valid RegistrationCustomerDTO registration) {
        RegistrationCustomerDTO registrationCustomerDTO = customerSecurity.registrationCustomer(registration);
        if (registrationCustomerDTO != null)
            return ResponseEntity.status(HttpStatus.CREATED).body(registrationCustomerDTO);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fallo la creación del usuario");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCustomerDTO login) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            final String username = customerSecurity.loginCustomer(login.getEmail());
            final String jwt = jwtUtil.generateToken(username);
            return ResponseEntity.ok().body(new LoginResponseDTO(login.getEmail(), jwt));
        } catch (BadCredentialsException e) {
            logger.error("Error en logeo", e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales malas");
        } catch (DisabledException disabledException) {
            logger.error("Error en logeo", disabledException);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales malas");
        } catch (Exception ex) {
            logger.error("Error general: " + ex.getMessage() , ex);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales malas");
        }
        
    }
    
}
