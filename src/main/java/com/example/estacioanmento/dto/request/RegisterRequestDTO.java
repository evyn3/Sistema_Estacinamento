package com.example.estacioanmento.dto.request;

public record RegisterRequestDTO(
        String cpf,
        String nome,
        String email,
        String telefone,
        String senha,
        String cnh)
{}
