package com.catalyst.dronedelivery.dtos.requests;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String email;
    private String lastName;
    private String firstName;
    private String address;
    private String phoneNumber;
}
