package com.olympics.platform.u202212760.platform.olympics.domain.model.entities;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullname;

    @ManyToOne
    @JoinColumn(name="agency_id")
    @NotNull
    private Reservation reservation;

    public Client(String name, Reservation reservation) {
        this.fullname = name;
        this.reservation = reservation;
    }

    public Client(){

    }
}