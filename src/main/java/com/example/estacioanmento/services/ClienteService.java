package com.example.estacioanmento.services;

import com.example.estacioanmento.entities.Cliente;
import com.example.estacioanmento.repositories.ClienteRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Long conversor(String cpf){
        Long x = Long.parseLong(cpf);
        return x;
    }
    public Cliente findById(String cpf) {
        Optional<Cliente> obj = repository.findById(conversor(cpf));
        return obj.orElseThrow(() -> new ResourceNotFoundException(cpf));
    }
}
