package com.olympics.platform.u202212760.platform.olympics.infraestructure.persistence.jpa.repository;

import com.olympics.platform.u202212760.platform.olympics.domain.model.aggregates.Reservation;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    //un boolean de No permite que se registre dos reservation con el mismo nameRestaurant y
    //dateReservation
    boolean existsByNameRestaurantAndDateReservation(@NotBlank String nameRestaurant, java.sql.Date dateReservation);
}
