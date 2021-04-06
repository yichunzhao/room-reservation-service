package com.ynz.democloud.roomreservationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class RoomReservation {
    private Long roomId;
    private Long guestId;
    private String roomName;
    private String roomNumber;
    private String firstName;
    private String lastName;
    private String date;
}
