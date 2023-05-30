package com.catalyst.dronedelivery.service;

import com.catalyst.dronedelivery.data.model.Drone;
import com.catalyst.dronedelivery.data.repository.DroneRepo;
import com.catalyst.dronedelivery.dtos.requests.DroneDto;
import com.catalyst.dronedelivery.exception.DroneAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class DroneServiceImpl implements DroneService{


    private final DroneRepo droneRepo;

    @Override
    public Drone addDrone(DroneDto drone) {
        Drone orderDrone = Drone.builder()
                .name(drone.getDroneName())
                .weightLimit(drone.getWeightLimit())
                .droneFee(drone.getDroneFee())
                .build();
        Drone savedDrone = droneRepo.save(orderDrone);
        return savedDrone;
    }

    @Override
    public Drone findDrone(Long id) {
       return droneRepo.findById(id).orElseThrow(() -> new DroneAppException("Cannot Find Drone"));
    }

    @Override
    public Optional<Drone> findDroneByName(String droneName) {
            return droneRepo.findByName(droneName);//.orElseThrow(() -> new DroneAppException("Drone not found"));

    }

    @Override
    public String deleteById(Long id) {
        Drone drone = droneRepo.findById(id).orElseThrow(() -> new DroneAppException("Cannot Find Drone"));
        droneRepo.delete(drone);
        return "Deleted Successfully";
    }
}
