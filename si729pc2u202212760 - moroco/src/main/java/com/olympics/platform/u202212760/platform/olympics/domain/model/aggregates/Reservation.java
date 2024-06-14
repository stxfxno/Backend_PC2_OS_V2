package com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates;

import com.olympics.platform.u202212760.platform.olympics.domain.model.commands.CreateReservationCommand;
import com.olympics.platform.u202212760.platform.olympics.domain.model.entities.Client;
import com.olympics.platform.u202212760.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.sql.Date;

@Entity
@Getter
public class Reservation{

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nameRestaurant;

    @Getter
    @NotNull(message="Business ID is mandatory")
    private Long clientId;

    @Column(nullable = false)
    private Date dateReservation;

    @Column(nullable = false)
    private Long countPerson;

    public Reservation(CreateReservationCommand command) {
        this.nameRestaurant = command.nameRestaurant();
        this.clientId = command.clientId();
        this.dateReservation = new Date(command.dateReservation().getTime()); // Convert to java.sql.Date
        this.countPerson = command.countPerson();
    }

    public Reservation() {
        this.nameRestaurant = "";
        this.clientId = 0L;
        this.dateReservation = new Date(0);
        this.countPerson = 0L;
    }
}