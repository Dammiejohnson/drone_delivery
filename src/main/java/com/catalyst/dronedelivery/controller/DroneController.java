package com.catalyst.dronedelivery.controller;

import com.catalyst.dronedelivery.data.model.Drone;
import com.catalyst.dronedelivery.dtos.requests.DroneDto;
import com.catalyst.dronedelivery.service.DroneService;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/droneDelivery")
@RequiredArgsConstructor
public class DroneController {

    private final DroneService droneService;

    @PostMapping("/addDrone")
    public ResponseEntity<Drone> addDrone(@RequestBody DroneDto droneDto) {
        var response = droneService.addDrone(droneDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findDroneById")
    public ResponseEntity<Drone> findDrone(@RequestParam Long id) {
        var response = droneService.findDrone(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/findDroneByName")
    public ResponseEntity<?> findDroneByName(@RequestParam String name) {
        var response = droneService.findDroneByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteDroneById/{id}")
    public ResponseEntity<?> deleteDrone(@PathVariable Long id) {
        var response = droneService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}