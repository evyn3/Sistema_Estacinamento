package com.example.estacioanmento.controller;

import com.example.estacioanmento.dto.request.LoginRequestDTO;
import com.example.estacioanmento.dto.request.RegisterRequestDTO;
import com.example.estacioanmento.dto.response.LoginResponseDTO;
import com.example.estacioanmento.entities.Cliente;
import com.example.estacioanmento.infra.security.TokenService;
import com.example.estacioanmento.repositories.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
//@RequiredArgsConstructor
public class AuthController {
    /*private ClienteRepository repository;
    private PasswordEncoder passwordEncoder;
    private TokenService tokenService;*/

    private final ClienteRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthController(
            ClienteRepository repository,
            PasswordEncoder passwordEncoder,
            TokenService tokenService
    ) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO body) {
        Cliente cliente = repository.findByEmail(body.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(body.senha(), cliente.getSenha())) {
            String token = tokenService.generateToken(cliente);
            return ResponseEntity.ok(new LoginResponseDTO(cliente.getNome(), token));
        }

        return ResponseEntity.badRequest().build();
    }

    /*@PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        Cliente cliente = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if(passwordEncoder.matches(body.senha(), cliente.getSenha())) {
            String token = this.tokenService.generateToken(cliente);
            return ResponseEntity.ok(new LoginRequestDTO(cliente.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }*/


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        System.out.println("CHEGOU NO REGISTER");
        Optional<Cliente> cliente = this.repository.findByEmail(body.email());

        if(cliente.isEmpty()) {
            Cliente novoCliente = new Cliente();
            if (body.senha() == null) {
                throw new RuntimeException("Senha não pode ser nula");
            }
            novoCliente.setCpf(body.cpf());
            novoCliente.setNome(body.nome());
            novoCliente.setEmail(body.email());
            novoCliente.setTelefone(body.telefone());
            novoCliente.setCnh(body.cnh());

            novoCliente.setSenha(passwordEncoder.encode(body.senha()));
            System.out.println("SENHA RECEBIDA: " + body.senha());

            this.repository.save(novoCliente);

            String token = this.tokenService.generateToken(novoCliente);
            return ResponseEntity.ok(new LoginResponseDTO(novoCliente.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
