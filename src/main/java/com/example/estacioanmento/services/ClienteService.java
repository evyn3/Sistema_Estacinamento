package com.example.estacioanmento.services;

import com.example.estacioanmento.entities.Cliente;
import com.example.estacioanmento.repositories.ClienteRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    //@Autowired
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    //lista os clientes
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    //converte o string(cpf) em long
    public Long conversor(String cpf){
        Long x = Long.parseLong(cpf);
        return x;
    }

    //pesquisa pelo cpf
    public Cliente findById(String cpf) {
        Optional<Cliente> obj = repository.findById(cpf);
        return obj.orElseThrow(() -> new ResourceNotFoundException(cpf));
    }

    //insere um cliente no banco
    public Cliente insert(Cliente obj){
        return repository.save(obj);
    }

    //deleta um cliente do banco
    public void delete(String cpf){
        try{
            repository.deleteById(cpf);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(cpf);
        }
    }

    //atualiza os dados
    public Cliente update(String cpf, Cliente obj){
        try{
            Cliente cliente = repository.findById(cpf)
                    .orElseThrow(() -> new ResourceNotFoundException(cpf));
            //Cliente cliente = repository.getOne(cpf);
            updateData(cliente, obj);
            return repository.save(cliente);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(cpf);
        }
    }

    private void updateData (Cliente entidade, Cliente obj){
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());
        entidade.setSenha(obj.getSenha());
    }

}
