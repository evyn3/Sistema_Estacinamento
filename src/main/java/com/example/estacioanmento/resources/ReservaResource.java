package com.example.estacioanmento.resources;

import com.example.estacioanmento.dto.request.ReservaRequest;
import com.example.estacioanmento.entities.Reserva;
import com.example.estacioanmento.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaResource {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?> criarReserva(@RequestBody ReservaRequest dto) {
        Reserva reserva = reservaService.criarReserva(dto);
        return ResponseEntity.ok(reserva);
    }
}