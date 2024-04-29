package com.example.appointment.dirver.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor

public class Article {

    private String name;
    private String mobilePhone;
    private Date date;
}
