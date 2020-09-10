package com.ynz.democloud.roomreservationservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room-reservations")
@RequiredArgsConstructor
public class RoomReservationWebService {
    private final RoomClient roomClient;

    @GetMapping
    public ResponseEntity<List<RoomReservation>> getRoomReservations() {
        List<Room> rooms = roomClient.getAllRooms();
        List<RoomReservation> reservations = new ArrayList<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = RoomReservation.builder().roomNumber(room.getRoomNum())
                    .roomId(room.getId()).roomName(room.getName()).build();

            reservations.add(roomReservation);
        });

        return ResponseEntity.ok(reservations);
    }


}
