package com.example.estacioanmento.entities;

import com.example.estacioanmento.enums.StatusVaga;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vaga")
public class Vaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;

    @Enumerated(EnumType.STRING)
    private StatusVaga status;

    public Vaga() {
    }

    public Vaga(String numero, StatusVaga status) {
        this.numero = numero;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public StatusVaga getStatus() {
        return status;
    }

    public void setStatus(StatusVaga status) {
        this.status = status;
    }
}
