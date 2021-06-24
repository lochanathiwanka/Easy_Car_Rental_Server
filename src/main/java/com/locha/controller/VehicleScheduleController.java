package com.locha.controller;

import com.locha.dto.VehicleScheduleDTO;
import com.locha.service.VehicleScheduleService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle_schedule")
@CrossOrigin
public class VehicleScheduleController {

    @Autowired
    private VehicleScheduleService vehicleScheduleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addVehicleSchedule(@RequestBody VehicleScheduleDTO dto) {
        vehicleScheduleService.addVehicleSchedule(dto);
        return new ResponseEntity(new StandardResponse("200", "Vehicle's schedule added", null), HttpStatus.CREATED);
    }

    @GetMapping(path = "/last_id")
    public ResponseEntity getLastId() {
        String lastId = vehicleScheduleService.getLastId();
        return new ResponseEntity(new StandardResponse("200", "Done", lastId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllVehicleSchedules() {
        ArrayList<VehicleScheduleDTO> all = vehicleScheduleService.getAll();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicleSchedule(@RequestBody VehicleScheduleDTO dto) {
        vehicleScheduleService.updateSchedule(dto);
        return new ResponseEntity(new StandardResponse("200", "Vehicle schedule updated!", null), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicleSchedule(@RequestParam String id) {
        vehicleScheduleService.deleteSchedule(id);
        return new ResponseEntity(new StandardResponse("200", "Vehicle schedule deleted!", null), HttpStatus.OK);
    }
}
