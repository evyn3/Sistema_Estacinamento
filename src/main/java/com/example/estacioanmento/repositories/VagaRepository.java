package com.example.estacioanmento.repositories;

import com.example.estacioanmento.enums.StatusVaga;
import com.example.estacioanmento.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    Optional<Vaga> findByNumero(String numero);

}