package com.example.appointment.vehicle.controller.model;

import lombok.Builder;
import org.axonframework.modelling.command.AggregateIdentifier;

@Builder
public record VehicleCommand(
        String name,
        String number,
        @AggregateIdentifier String eventId) {


}
