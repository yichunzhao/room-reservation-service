package com.ynz.democloud.roomreservationservice.dao;

import com.ynz.democloud.roomreservationservice.domain.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("roomservices")
public interface RoomClient {

    @GetMapping("/rooms")
    List<Room> getAllRooms();

    @GetMapping("/rooms/{id}")
    Room getRoomById(@PathVariable("id") Long id);

}
