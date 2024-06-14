package com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform;

import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateReservationCommand;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.CreateReservationResource;

import java.text.SimpleDateFormat;

public class CreateReservationCommandFromResourceAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource sportmanResource) {
        return new CreateReservationCommand(
                sportmanResource.nameRestaurant(),
                sportmanResource.clientId(),
                sportmanResource.dateReservation(),
                sportmanResource.countPerson()
        );
    }
}