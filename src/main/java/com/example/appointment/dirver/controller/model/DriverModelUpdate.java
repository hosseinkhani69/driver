package com.example.appointment.dirver.controller.model;

import lombok.Builder;
import org.axonframework.modelling.command.AggregateIdentifier;


@Builder
public record DriverModelUpdate(String name,

                                String fullName,

                                String modelVehicle,
                                Integer id
                        ) {


}
