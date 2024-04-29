package com.example.appointment.vehicle.service;

import com.example.appointment.vehicle.orm.Vehicle;
import com.example.appointment.vehicle.orm.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class VehicleEventHandler {

    public final VehicleRepository vehicleRepository;

    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void create(VehicleEventModel driverModelCreate) throws Exception {
        Vehicle vehicle = new Vehicle();
        BeanUtils.copyProperties( driverModelCreate,vehicle);
        vehicleRepository.save(vehicle);

    }

}
