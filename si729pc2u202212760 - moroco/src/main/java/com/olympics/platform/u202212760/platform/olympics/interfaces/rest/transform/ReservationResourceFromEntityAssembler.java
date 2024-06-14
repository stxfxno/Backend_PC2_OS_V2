package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Reservation;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation sportman) {
        return new ReservationResource(
                /*
                *   Long id,
                    String name,
                    Long athleticDisciplineId,
                    String country,
                    Date year
                * */

                sportman.getId(),
                sportman.getNameRestaurant(),
                sportman.getClientId(),
                sportman.getDateReservation(),
                sportman.getCountPerson()

        );
    }

}
