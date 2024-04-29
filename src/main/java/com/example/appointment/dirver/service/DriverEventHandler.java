package com.example.appointment.dirver.service;

import com.example.appointment.dirver.orm.Driver;
import com.example.appointment.dirver.orm.DriverRepository;
import com.example.appointment.vehicle.service.VehicleEventHandler;
import com.example.appointment.vehicle.service.VehicleEventModel;
import lombok.RequiredArgsConstructor;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DriverEventHandler {


    public final DriverRepository driverRepository;
    public final VehicleEventHandler v;
    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void create(DriverEventModelCreate driverModelCreate) throws Exception {
        Driver driver = new Driver();
        VehicleEventModel vehicleEventModel=new VehicleEventModel();
        vehicleEventModel.setName(driverModelCreate.getName());
        vehicleEventModel.setNumber(driverModelCreate.getModelVehicle());
        v.create(vehicleEventModel);
        BeanUtils.copyProperties( driverModelCreate,driver);
        driverRepository.save(driver);

    }
    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void delete(DriverEventModelDelete driverModelDelete) throws Exception {
        Driver driver = driverRepository.findById(driverModelDelete.getId())
                .orElseThrow(()-> new Exception("DRIVER_NOT_FOUND"));
        driverRepository.delete(driver);

    }
    @EventHandler
    @Transactional(rollbackFor = Exception.class)
    public void update(DriverEventModelUpdate driverModelUpdate) throws Exception {
        Driver driver = driverRepository.findById(driverModelUpdate.getId())
                .orElseThrow(()-> new Exception("DRIVER_NOT_FOUND"));
        BeanUtils.copyProperties( driverModelUpdate,driver);
        driverRepository.save(driver);

    }}
