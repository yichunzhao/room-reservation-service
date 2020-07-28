package com.ynz.democloud.roomreservationservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    private Long id;
    private String name;
    private String roomNum;
    private String bedInfo;
}
