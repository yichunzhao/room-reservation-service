package com.ynz.democloud.roomreservationservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Room {
    private Long id;
    private String name;
    private String roomNum;
    private String bedInfo;
}
