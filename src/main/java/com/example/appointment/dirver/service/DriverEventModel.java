package com.example.appointment.dirver.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverEventModel {
    private   String name;
    private  String fullName;
    private    String modelVehicle;

    @AggregateIdentifier
    private String eventId;
    private Integer id;
}
