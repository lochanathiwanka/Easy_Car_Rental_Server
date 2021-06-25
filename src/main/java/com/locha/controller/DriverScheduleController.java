package com.locha.controller;

import com.locha.dto.DriverScheduleDTO;
import com.locha.service.DriverScheduleService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/driver_schedule")
@CrossOrigin
public class DriverScheduleController {

    @Autowired
    private DriverScheduleService driverScheduleService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDriverSchedule(@RequestBody DriverScheduleDTO dto) {
        driverScheduleService.addDriverSchedule(dto);
        return new ResponseEntity(new StandardResponse("200", "Driver's schedule added", null), HttpStatus.CREATED);
    }

    @GetMapping(path = "/last_id")
    public ResponseEntity getLastId() {
        String lastId = driverScheduleService.getLastId();
        return new ResponseEntity(new StandardResponse("200", "Done", lastId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAllDriverSchedules() {
        ArrayList<DriverScheduleDTO> all = driverScheduleService.getAll();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }

    @GetMapping(path = "get/{id}")
    public ResponseEntity getDriverScheduleById(@PathVariable String id) {
        ArrayList<DriverScheduleDTO> schedule = driverScheduleService.getScheduleById(id);
        return new ResponseEntity(new StandardResponse("200", "Done", schedule), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDriverSchedule(@RequestBody DriverScheduleDTO dto) {
        driverScheduleService.updateSchedule(dto);
        return new ResponseEntity(new StandardResponse("200", "Driver schedule updated!", null), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteDriverSchedule(@RequestParam String id) {
        driverScheduleService.deleteSchedule(id);
        return new ResponseEntity(new StandardResponse("200", "Driver schedule deleted!", null), HttpStatus.OK);
    }

}
