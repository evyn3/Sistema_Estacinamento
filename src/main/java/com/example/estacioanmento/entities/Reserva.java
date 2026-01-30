package com.example.estacioanmento.entities;

import com.example.estacioanmento.enums.StatusReserva;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "cliente_cpf")
    private Cliente cliente;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    public Reserva() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Vaga getVaga() { return vaga; }

    public void setVaga(Vaga vaga) { this.vaga = vaga; }

    public Cliente getCliente() {return cliente;}

    public void setCliente(Cliente cliente) {this.cliente = cliente;}

    public LocalDateTime getInicio() { return inicio; }

    public void setInicio(LocalDateTime inicio) { this.inicio = inicio; }

    public LocalDateTime getFim() { return fim; }

    public void setFim(LocalDateTime fim) { this.fim = fim; }

    public StatusReserva getStatus() {return status;}

    public void setStatus(StatusReserva status) {this.status = status;}

}