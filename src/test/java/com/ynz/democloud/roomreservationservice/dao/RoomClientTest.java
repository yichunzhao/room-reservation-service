package com.ynz.democloud.roomreservationservice.dao;

import com.ynz.democloud.roomreservationservice.domain.Room;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class RoomClientTest {
    @Autowired
    private RoomClient roomClient;

    @Test
    void getRoomById() {
        Room found = roomClient.getRoomById(1L);

        assertAll(
                () -> assertNotNull(found),
                () -> assertThat(found.getName(), equalTo("Piccadilly")),
                () -> assertThat(found.getRoomNum(), equalTo("P1")),
                () -> assertThat(found.getBedInfo(), equalTo("1Q"))
        );
    }

}