package com.example.appointment.vehicle.controller;

import com.example.appointment.dirver.controller.model.DriverDeleteCommand;
import com.example.appointment.dirver.controller.model.DriverModelUpdate;
import com.example.appointment.dirver.controller.model.DriverUpdateCommand;
import com.example.appointment.vehicle.controller.model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleCommandController {
    private final CommandGateway commandGateway;

    @PostMapping("")
    public ResponseEntity<String> Create(@RequestBody @Valid VehicleModelCreate driverModelCreate) {

        try {
        commandGateway.sendAndWait(VehicleCommand.builder()
                .eventId(UUID.randomUUID().toString())

                .name(driverModelCreate.name())
                .number(driverModelCreate.number())
                .build());
        } catch (Exception e) {
            return new ResponseEntity<>("FAILED",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("your turn is recorded", HttpStatus.CREATED);
    }

}

