package com.olympics.platform.u202212760.platform.olympics.domain.services;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Reservation;
import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateReservationCommand;

import java.util.Optional;

public interface ReservationCommandService {
        Optional<Reservation>handle(CreateReservationCommand command);
}
