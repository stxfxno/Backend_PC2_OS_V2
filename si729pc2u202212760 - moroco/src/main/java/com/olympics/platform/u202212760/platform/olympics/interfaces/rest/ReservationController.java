package com.olympics.platform.u202212760.platform.olympics.interfaces.rest;
import com.olympics.platform.u202212760.platform.olympics.domain.services.ReservationCommandService;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.resources.CreateReservationResource;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform.CreateReservationCommandFromResourceAssembler;
import com.olympics.platform.u202212760.platform.olympics.interfaces.rest.transform.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reservation", description = "Reservation Management Endpoints")
public class ReservationController {

    private final ReservationCommandService reservationService;

    public ReservationController(ReservationCommandService reservationService) {
        this.reservationService = reservationService;
    }

    @Operation(summary="Create a new Reservation", description="Create a new Reservation with the input data.")
    @PostMapping
    public ResponseEntity<?> createReservation(@RequestBody CreateReservationResource resource){
        var command = CreateReservationCommandFromResourceAssembler.toCommandFromResource(resource);
        var reservation = reservationService.handle(command);
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);
    }
}