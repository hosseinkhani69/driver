package com.example.appointment.dirver.controller;

import com.example.appointment.dirver.controller.model.*;
import com.example.appointment.dirver.service.DriverEventModelDelete;
import com.example.appointment.dirver.service.DriverEventModelUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/driver")
public class DriverCommandController {
    private final CommandGateway commandGateway;

    @PostMapping("")
    public ResponseEntity<String> Create(@RequestBody @Valid DriverModelCreate driverModelCreate) {

        try {
        commandGateway.sendAndWait(DriverCommand.builder()
                .eventId(UUID.randomUUID().toString())
                 .fullName(driverModelCreate.fullName())
                .name(driverModelCreate.name())
                .modelVehicle(driverModelCreate.modelVehicle())
                .build());
        } catch (Exception e) {
            return new ResponseEntity<>("FAILED",HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("your turn is recorded", HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        commandGateway.sendAndWait(DriverDeleteCommand.builder()
                .eventId(UUID.randomUUID().toString())
                .id(id)
                .build());
        return  Boolean.TRUE;
    }


    @PutMapping("/{id}")
    public Boolean update(@RequestBody @Valid DriverModelUpdate driverEventModelUpdate, @PathVariable Integer id) {
        commandGateway.sendAndWait(DriverUpdateCommand.builder()
                .eventId(UUID.randomUUID().toString())
                .name(driverEventModelUpdate.name())
                .fullName(driverEventModelUpdate.fullName())
                .id(id)
                .modelVehicle(driverEventModelUpdate.modelVehicle())
                .build());
        return  Boolean.TRUE;
    }

}

