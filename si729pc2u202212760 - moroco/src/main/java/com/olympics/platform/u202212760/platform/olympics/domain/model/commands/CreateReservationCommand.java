package com.olympics.platform.u202212760.platform.olympics.domain.model.commands;

import java.util.Date;

public record CreateReservationCommand(
        String nameRestaurant,
        Long clientId,
        Date dateReservation,
        Long countPerson
) {

}
