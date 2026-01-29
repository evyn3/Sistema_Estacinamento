package com.example.estacioanmento.repositories;

import com.example.estacioanmento.entities.Reserva;
import com.example.estacioanmento.enums.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByVagaIdAndStatus(Long vagaId, StatusReserva status);
}
