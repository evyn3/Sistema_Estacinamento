package com.example.estacioanmento.services;

import com.example.estacioanmento.dto.request.ReservaRequest;
import com.example.estacioanmento.entities.Reserva;
import com.example.estacioanmento.enums.StatusReserva;
import com.example.estacioanmento.entities.Vaga;
import com.example.estacioanmento.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private VagaService vagaService;

    public Reserva criarReserva(ReservaRequest dto) {

        Vaga vaga = vagaService.buscarVagaPorNumero(dto.getNumeroVaga());

        List<Reserva> reservasAtivas =
                reservaRepository.findByVagaIdAndStatus(
                        vaga.getId(),
                        StatusReserva.ATIVA
                );

        for (Reserva r : reservasAtivas) {
            boolean conflito =
                    dto.getInicio().isBefore(r.getFim()) &&
                            dto.getFim().isAfter(r.getInicio());

            if (conflito) {
                throw new RuntimeException(
                        "Ja existe uma reserva para este horario"
                );
            }
        }

        Reserva reserva = new Reserva();
        reserva.setInicio(dto.getInicio());
        reserva.setFim(dto.getFim());
        reserva.setStatus(StatusReserva.ATIVA);
        reserva.setVaga(vaga);

        Reserva reservaSalva = reservaRepository.save(reserva);

        vagaService.marcarComoReservada(vaga);

        return reservaSalva;
    }
}