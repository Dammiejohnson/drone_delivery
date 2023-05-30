package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Drone;
import com.catalyst.dronedelivery.dtos.requests.DroneDto;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface DroneService {
    Drone addDrone(DroneDto drone);
    Drone findDrone(Long id);
    Optional<Drone> findDroneByName(String name);
    String deleteById(Long id);

}
