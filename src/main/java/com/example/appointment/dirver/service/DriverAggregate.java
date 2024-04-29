package com.example.appointment.dirver.service;

import com.example.appointment.dirver.controller.model.DriverCommand;
import com.example.appointment.dirver.controller.model.DriverDeleteCommand;
import com.example.appointment.dirver.controller.model.DriverModelUpdate;
import com.example.appointment.dirver.controller.model.DriverUpdateCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Aggregate
@NoArgsConstructor
public class DriverAggregate {

    private String name;
    private String fullName;
    private String modelVehicle;

    @AggregateIdentifier
    private String eventId;
    private Integer id;


    @CommandHandler
    public DriverAggregate(DriverCommand driverCommand) {
        DriverEventModelCreate driverEventModel = new DriverEventModelCreate();
        BeanUtils.copyProperties(driverCommand, driverEventModel);
        AggregateLifecycle.apply(driverEventModel);
    }


    @EventSourcingHandler
    public void create(DriverEventModelCreate driverEventModel) {
        this.eventId = driverEventModel.getEventId();
        this.name = driverEventModel.getName();
        this.fullName = driverEventModel.getFullName();
        this.modelVehicle = driverEventModel.getModelVehicle();

    }

    @CommandHandler
    public DriverAggregate(DriverDeleteCommand driverCommand) {
        DriverEventModelDelete driverEventModel = new DriverEventModelDelete();
        BeanUtils.copyProperties(driverCommand, driverEventModel);
        AggregateLifecycle.apply(driverEventModel);
    }

    @EventSourcingHandler
    public void delete(DriverEventModelDelete driverEventModel) {
        this.eventId = driverEventModel.getEventId();
        this.id = driverEventModel.getId();
    }

    @CommandHandler
    public DriverAggregate(DriverUpdateCommand driverCommand, QueryGateway queryGateway) {
        RestClient restClient = RestClient.create();
        Article result = restClient.get()
                .uri("http://localhost:9801/appointment/appointment-registration/3")
                .retrieve()
                .body(Article.class);
        if (result.getName().equals("linda")) {

                driverCommand.setName(result.getName());


        } else {

        }



        DriverEventModelUpdate driverEventModel = new DriverEventModelUpdate();
        BeanUtils.copyProperties(driverCommand, driverEventModel);
        AggregateLifecycle.apply(driverEventModel);
    }

    @EventSourcingHandler
    public void update(DriverEventModelUpdate driverEventModel) {

        this.eventId = driverEventModel.getEventId();
        this.id = driverEventModel.getId();
    }
}