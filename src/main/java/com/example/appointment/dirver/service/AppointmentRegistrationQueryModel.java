package com.example.appointment.dirver.service;

import lombok.Data;

import java.util.Date;

@Data
public class AppointmentRegistrationQueryModel {
   private String name;
   private String mobilePhone;
   private Date date;
}

