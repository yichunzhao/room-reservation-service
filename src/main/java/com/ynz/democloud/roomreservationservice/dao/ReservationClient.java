package com.ynz.democloud.roomreservationservice.dao;

import com.ynz.democloud.roomreservationservice.domain.Reservation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

@FeignClient("RESERVATIONSERVICES")
public interface ReservationClient {

    @GetMapping("reservations/dates/{restDate}")
    List<Reservation> getReservationsByDate(@PathVariable("restDate") Date date);

    @GetMapping("reservations")
    List<Reservation> getAllReservations();
}
