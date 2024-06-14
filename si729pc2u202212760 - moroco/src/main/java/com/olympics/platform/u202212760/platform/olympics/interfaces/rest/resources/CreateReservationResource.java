package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources;

import java.util.Date;

public record CreateReservationResource(
        String nameRestaurant,
        Long clientId,
        Date dateReservation,
        Long countPerson
) {
}
