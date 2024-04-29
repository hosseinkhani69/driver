package com.example.appointment.vehicle.service;


import com.example.appointment.vehicle.controller.model.VehicleCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
@NoArgsConstructor
public class VehicleAggregate {

    private String name;
    private String number;

    @AggregateIdentifier
    private String eventId;
    private Integer id;


    @CommandHandler
    public VehicleAggregate(VehicleCommand driverCommand) {
        VehicleEventModel vehicleEventModel = new VehicleEventModel();
        BeanUtils.copyProperties(driverCommand, vehicleEventModel);
        AggregateLifecycle.apply(vehicleEventModel);
    }


    @EventSourcingHandler
    public void create(VehicleEventModel vehicleEventModel) {
        this.eventId = vehicleEventModel.getEventId();
        this.name = vehicleEventModel.getName();
        this.number = vehicleEventModel.getName();
    }

    }



