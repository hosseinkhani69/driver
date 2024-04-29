package com.example.appointment.vehicle.controller.model;

import lombok.Builder;


@Builder
public record VehicleModelCreate(String name,

                                 String number, Integer id) {


}
