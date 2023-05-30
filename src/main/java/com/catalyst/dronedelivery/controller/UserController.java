package com.catalyst.dronedelivery.controller;

import com.catalyst.dronedelivery.data.model.Product;
import com.catalyst.dronedelivery.data.model.User;
import com.catalyst.dronedelivery.dtos.requests.UserDto;
import com.catalyst.dronedelivery.dtos.responses.UserDtoResponse;
import com.catalyst.dronedelivery.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/droneDelivery")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<UserDtoResponse> addUser(@RequestBody UserDto userDto){
        var response = userService.signUp(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/getUser")
    public  ResponseEntity<?> getUser(@RequestParam Long id){
        var response = userService.findUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser")
    public  ResponseEntity<?> removeUser(@RequestParam Long id){
        var response = userService.deleteUserById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/updateUser")
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        var response = userService.updateUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
