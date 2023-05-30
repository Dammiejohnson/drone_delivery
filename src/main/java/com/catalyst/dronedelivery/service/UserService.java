package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.User;
import com.catalyst.dronedelivery.dtos.requests.UserDto;
import com.catalyst.dronedelivery.dtos.responses.UserDtoResponse;

public interface UserService {
    UserDtoResponse signUp(UserDto userDto);
    User findUserById(Long id);
    String deleteUserById(Long id);
    UserDtoResponse updateUser(User user);
}
