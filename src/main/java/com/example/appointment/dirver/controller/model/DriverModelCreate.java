package com.example.appointment.dirver.controller.model;

import lombok.Builder;


@Builder
public record DriverModelCreate (     String name,

         String fullName,

         String modelVehicle,Integer id){


}
