package com.example.estacioanmento.resources;

import com.example.estacioanmento.entities.Vaga;
import com.example.estacioanmento.enums.StatusVaga;
import com.example.estacioanmento.repositories.VagaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vagas")
@CrossOrigin(origins = "*")

public class VagaResource {
    private final VagaRepository vagaRepository;

    public VagaResource(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @GetMapping
    public List<Vaga> listarVagas() {
        return vagaRepository.findAll();
    }
}
