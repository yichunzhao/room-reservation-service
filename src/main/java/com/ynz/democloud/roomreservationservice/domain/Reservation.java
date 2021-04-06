package com.ynz.democloud.roomreservationservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    private Long id;
    private Long roomId;
    private Long guestId;
    private Date restDate;
}
