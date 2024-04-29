package com.example.appointment.dirver.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverEventModelDelete {
    private  Integer id;

    private String eventId;
}
