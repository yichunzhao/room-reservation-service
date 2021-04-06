package com.ynz.democloud.roomreservationservice.dao;

import com.ynz.democloud.roomreservationservice.domain.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

@SpringBootTest
class ReservationClientTest {
    @Autowired
    private ReservationClient reservationClient;

    @Test
    void getReservationsByDate() throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2020-01-01");

//        String date = "2020-01-01";

        List<Reservation> roomReservations = reservationClient.getReservationsByDate(date);
        assertThat(roomReservations, hasSize(1));

    }

    @Test
    void getAllReservations() {
        List<Reservation> reservations = reservationClient.getAllReservations();
        assertThat(reservations,hasSize(1));

    }
}