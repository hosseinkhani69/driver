package com.example.appointment.dirver.controller.model;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
@Data
@Builder
public class DriverDeleteCommand {
    private  Integer id;

    @AggregateIdentifier
    private String eventId;
}
