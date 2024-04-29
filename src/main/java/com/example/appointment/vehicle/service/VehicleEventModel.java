package com.example.appointment.vehicle.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEventModel {
    private   String name;
    private  String number;

    @AggregateIdentifier
    private String eventId;
    private Integer id;
}
