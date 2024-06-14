package com.olympics.platform.u202212760.platform.olympics.application.internal.commandservices;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Reservation;
import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateReservationCommand;
import com.olympics.platform.u202212760.platform.olympics.domain.services.ReservationCommandService;
import com.olympics.platform.u202212760.platform.olympics.infraestructure.persistence.jpa.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {

    private final ReservationRepository sportmanRepository;

    public ReservationCommandServiceImpl(ReservationRepository sportmanRepository) {
        this.sportmanRepository = sportmanRepository;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        Reservation reservation = new Reservation(command);
        reservation = sportmanRepository.save(reservation); // Guarda la reserva en la base de datos
        return Optional.of(reservation);
    }
}