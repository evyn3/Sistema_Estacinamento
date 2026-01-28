package com.example.estacioanmento.config;

import com.example.estacioanmento.entities.Cliente;
import com.example.estacioanmento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class Teste implements CommandLineRunner {

    @Autowired
    public ClienteRepository clienteRepository;

    public void run(String... args) throws Exception {
        Cliente c1 = new Cliente("123.456.789-10", "Evelyn", "evelyn@gmail.com", "74 98843-7504", "123456", "1234567890");

        clienteRepository.saveAll(Arrays.asList(c1));
    }
}
