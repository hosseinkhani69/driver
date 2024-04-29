package com.example.appointment.dirver.service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DriverEventUpdateModel {
    private String name;
    private String fullName;
    private String modelVehicle;
    private String eventId;
    private Integer id;
}
