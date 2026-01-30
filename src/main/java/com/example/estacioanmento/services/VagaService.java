package com.example.estacioanmento.services;

import com.example.estacioanmento.enums.StatusVaga;
import com.example.estacioanmento.entities.Vaga;
import com.example.estacioanmento.repositories.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga buscarVagaPorNumero(String numeroVaga) {

        Optional<Vaga> vagaOpt = vagaRepository.findByNumero(numeroVaga);

        if (vagaOpt.isEmpty()) {
            throw new RuntimeException("Vaga não encontrada");
        }

        return vagaOpt.get();
    }

    public void marcarComoReservada(Vaga vaga) {
        vaga.setStatus(StatusVaga.RESERVADA);
        vagaRepository.save(vaga);
    }


}