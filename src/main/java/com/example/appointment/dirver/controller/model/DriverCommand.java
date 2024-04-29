package com.example.appointment.dirver.controller.model;

import lombok.Builder;

import org.axonframework.modelling.command.AggregateIdentifier;

@Builder
public record DriverCommand(
        String name,
        String fullName,
        String modelVehicle,
        @AggregateIdentifier String eventId) {


}
