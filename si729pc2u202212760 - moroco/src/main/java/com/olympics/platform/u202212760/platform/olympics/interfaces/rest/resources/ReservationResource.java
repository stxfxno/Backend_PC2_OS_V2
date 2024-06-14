package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources;

import java.util.Date;

public record ReservationResource(
        Long id,
        String nameRestaurant,
        Long clientId,
        Date dateReservation,
        Long countPerson){

}
