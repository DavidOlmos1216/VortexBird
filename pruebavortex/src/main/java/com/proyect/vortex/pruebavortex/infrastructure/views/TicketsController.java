package com.proyect.vortex.pruebavortex.infrastructure.views;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.vortex.pruebavortex.application.datatransferobject.TicketsDTO;
import com.proyect.vortex.pruebavortex.application.services.ITicketsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/tickets")
public class TicketsController {

    private final ITicketsService ticketsService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public TicketsController(ITicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTikect(@RequestBody TicketsDTO ticketsDTO) {
        try {
            var tickets = ticketsService.createTicket(ticketsDTO);
            if (tickets != null)
                return ResponseEntity.ok(tickets);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error Creando tiket", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable("id") int ticketId) {
        try {
            ticketsService.deleteTicket(ticketId);
            return ResponseEntity.ok("Eliminado satisfactoriamente");
        } catch (Exception e) {
            logger.error("Error eliminando el tiket", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }

    @GetMapping("/get-by-customer-id")
    public ResponseEntity<?> createTikect(@RequestParam("customerId") int customerId) {
        try {
            var tickets = ticketsService.getTicketsByCustomer(customerId);
            if (tickets != null)
                return ResponseEntity.ok(tickets);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        } catch (Exception e) {
            logger.error("Error Creando tiket", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocurrio un problema");
        }
    }
    
    

}
