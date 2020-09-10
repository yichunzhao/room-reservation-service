package com.ynz.democloud.roomreservationservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("roomservices")
public interface RoomClient {

    @GetMapping("/rooms")
    List<Room> getAllRooms();

}
