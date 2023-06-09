package com.catalyst.dronedelivery.data.repository;

import com.catalyst.dronedelivery.data.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DroneRepo extends JpaRepository<Drone, Long> {
    Optional<Drone> findByName(String droneName);



}
