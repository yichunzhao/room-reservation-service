package com.ynz.democloud.roomreservationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("roomreservations")
@RequiredArgsConstructor
public class RoomReservationWebService {
    private final RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<RoomReservation>> getRoomReservations() {
        List<Room> rooms = getAllRooms();
        List<RoomReservation> reservations = new ArrayList<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = RoomReservation.builder().roomNumber(room.getRoomNum())
                    .roomId(room.getId()).roomName(room.getName()).build();

            reservations.add(roomReservation);
        });

        return ResponseEntity.ok(reservations);
    }

    private List<Room> getAllRooms() {

        ResponseEntity<List<Room>> responseEntity = restTemplate.exchange("http://ROOMSERVICES/rooms",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
                }
        );
        return responseEntity.getBody();
    }

}
