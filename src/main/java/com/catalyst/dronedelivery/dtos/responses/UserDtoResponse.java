package com.catalyst.dronedelivery.dtos.responses;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoResponse {
    private String email;
    private String message;

}
