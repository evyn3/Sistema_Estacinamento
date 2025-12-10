package com.example.estacioanmento.repositories;

import com.example.estacioanmento.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
