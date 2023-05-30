package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.User;
import com.catalyst.dronedelivery.data.repository.UserRepo;
import com.catalyst.dronedelivery.dtos.requests.UserDto;
import com.catalyst.dronedelivery.dtos.responses.UserDtoResponse;
import com.catalyst.dronedelivery.exception.DroneAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Override
    public UserDtoResponse signUp(UserDto userDto) {
      Optional <User> user = userRepo.findUserByEmail(userDto.getEmail());
        if(!user.isPresent()){
            User newUser = User.builder()
                    .email(userDto.getEmail())
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .address(userDto.getAddress())
                    .phoneNumber(userDto.getPhoneNumber())
                    .build();

            User savedUser = userRepo.save(newUser);
            return  UserDtoResponse.builder()
                    .email(savedUser.getEmail())
                    .message("Saved successfully")
                    .build();

        }
        throw new DroneAppException("User already exists");
    }


    @Override
    public User findUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new DroneAppException("User not found"));
    }

    @Override
    public String deleteUserById(Long id) {
        userRepo.deleteById(id);
        return "Deleted successfully";
    }

    @Override
    public UserDtoResponse updateUser(User user) {
        User foundUser = userRepo.findById(user.getId()).orElseThrow(() -> new DroneAppException("User with this id does not exist"));
        boolean isUpdate = false;

        if (!(user.getEmail()== null ||user.getEmail().trim().equals(""))){
            foundUser.setEmail(user.getEmail());
            isUpdate = true;}


        if (!(user.getFirstName()== null ||user.getFirstName().trim().equals(""))){
            foundUser.setFirstName(user.getFirstName());
            isUpdate = true;}

        if (!(user.getLastName()== null ||user.getLastName().trim().equals(""))){
            foundUser.setLastName(user.getLastName());
            isUpdate = true;}

        if (!(user.getAddress()== null ||user.getAddress().trim().equals(""))){
            foundUser.setAddress(user.getAddress());
            isUpdate = true;}

        if (!(user.getPhoneNumber()== null ||user.getPhoneNumber().trim().equals(""))){
            foundUser.setPhoneNumber(user.getPhoneNumber());
            isUpdate = true;}


        if (isUpdate){
            userRepo.save(foundUser);}

        return  UserDtoResponse.builder()
                .email(foundUser.getEmail())
                .message("Updated successfully")
                .build();

    }
}
