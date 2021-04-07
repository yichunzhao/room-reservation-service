package com.ynz.democloud.roomreservationservice.controllers;

import com.ynz.democloud.roomreservationservice.dao.GuestClient;
import com.ynz.democloud.roomreservationservice.dao.RoomClient;
import com.ynz.democloud.roomreservationservice.domain.Guest;
import com.ynz.democloud.roomreservationservice.domain.Reservation;
import com.ynz.democloud.roomreservationservice.domain.Room;
import com.ynz.democloud.roomreservationservice.domain.RoomReservation;
import com.ynz.democloud.roomreservationservice.exceptions.InvalidDateFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roomReservations")
@RequiredArgsConstructor
@Slf4j
public class RoomReservationController {
    private final RoomClient roomClient;
    private final GuestClient guestClient;

    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<RoomReservation>> getRoomReservationsByDate(@RequestParam(name = "date") String restDate) {
        validateStringDate(restDate);

        Map<Long, Room> roomIdRoomMap = roomClient.getAllRooms().stream()
                .collect(Collectors.toMap(Room::getId, v -> v, (o, n) -> n, TreeMap::new));

        List<RoomReservation> roomReservations = new ArrayList<>();

        List<Reservation> reservations = askForReservationByDate(restDate);

        for (Reservation reservation : reservations) {
            Long roomId = reservation.getRoomId();
            Room room = roomIdRoomMap.get(roomId);

            Long guestId = reservation.getGuestId();
            Guest guest = guestClient.findGuestById(guestId);

            RoomReservation roomReservation = RoomReservation.builder()
                    .roomId(reservation.getRoomId())
                    .roomName(room.getName())
                    .roomNumber(room.getRoomNum())
                    .firstName(guest.getFirstName())
                    .lastName(guest.getLastName())
                    .guestId(reservation.getGuestId())
                    .date(reservation.getRestDate().toString())
                    .build();

            roomReservations.add(roomReservation);
        }

        return ResponseEntity.ok(roomReservations);
    }

    private List<Reservation> askForReservationByDate(String date) {
        String uri = new StringBuilder("http://RESERVATIONSERVICES/reservations")
                .append("?date=").append(date).toString();

        log.info(uri);

        ResponseEntity<Reservation[]> responseEntity = this.restTemplate.getForEntity(uri, Reservation[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    private void validateStringDate(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {
            df.parse(date);
        } catch (ParseException e) {
            throw new InvalidDateFormat("Date format should be yyyy-MM-dd");
        }
    }

}
