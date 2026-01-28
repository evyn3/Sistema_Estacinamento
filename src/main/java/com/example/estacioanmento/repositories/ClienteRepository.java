package com.example.estacioanmento.repositories;

import com.example.estacioanmento.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    //Optional<Cliente> findByCpf(String cpf);

    //Optional<Cliente> findByEmail(String email);
}
