package com.example.appointment.dirver.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DriverEventModelUpdate {
  private   String name;

  private   String fullName;

   private String modelVehicle;
    private Integer id;
    @AggregateIdentifier
    private String eventId;


}
