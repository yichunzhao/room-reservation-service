package com.ynz.democloud.roomreservationservice.dao;

import com.ynz.democloud.roomreservationservice.domain.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("guestservice")
public interface GuestClient {

    @GetMapping("guests/{id}")
    Guest findGuestById(@PathVariable("id") Long id);

    @GetMapping("guests")
    List<Guest> findAllGuests();

}
