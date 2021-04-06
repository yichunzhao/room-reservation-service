package com.ynz.democloud.roomreservationservice.dao;

import com.ynz.democloud.roomreservationservice.domain.Guest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class GuestClientTest {
    @Autowired
    private GuestClient guestClient;

    @Test
    void findGuestById() {
        Guest found = guestClient.findGuestById(1L);
        assertNotNull(found);
        assertThat(found.getFirstName(), equalTo("Roy"));
    }

    @Test
    void findAllGuests() {
        List<Guest> guestList = guestClient.findAllGuests();
        assertThat(guestList, hasSize(200));
    }

}