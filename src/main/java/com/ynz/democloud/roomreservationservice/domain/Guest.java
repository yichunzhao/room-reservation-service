package com.ynz.democloud.roomreservationservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Guest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String country;
    private String state;
    private String phoneNumber;
}
