package com.example.estacioanmento.config;

import com.example.estacioanmento.entities.Vaga;
import com.example.estacioanmento.enums.StatusVaga;
import com.example.estacioanmento.repositories.VagaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final VagaRepository vagaRepository;

    public DataLoader(VagaRepository vagaRepository) {
        this.vagaRepository = vagaRepository;
    }

    @Override
    public void run(String... args) {
        if (vagaRepository.count() == 0) {
            vagaRepository.save(new Vaga("A1", StatusVaga.DISPONIVEL));
            vagaRepository.save(new Vaga("A2", StatusVaga.DISPONIVEL));
            vagaRepository.save(new Vaga("A3", StatusVaga.DISPONIVEL));
            vagaRepository.save(new Vaga("B1", StatusVaga.DISPONIVEL));
        }
    }
}
