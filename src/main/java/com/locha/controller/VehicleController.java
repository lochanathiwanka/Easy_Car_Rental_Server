package com.locha.controller;

import com.locha.dto.VehicleDTO;
import com.locha.service.VehicleService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity getAllVehicles() {
        ArrayList<VehicleDTO> allVehicles = vehicleService.findAllVehicles();
        return new ResponseEntity(new StandardResponse("200", "Done!", allVehicles), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity searchVehicle(@PathVariable String id) {
        VehicleDTO vehicle = vehicleService.findVehicleById(id);
        System.out.println("Vehicle id: " + vehicle.getVid());
        return new ResponseEntity(new StandardResponse("200", "Done!", vehicle), HttpStatus.CREATED);
    }

    @GetMapping(path = "/lastid")
    public ResponseEntity getLastVid() {
        String lastVid = vehicleService.getLastVid();
        return new ResponseEntity(new StandardResponse("200", "Done", lastVid), HttpStatus.CREATED);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addVehicle(@RequestBody VehicleDTO dto) {
        vehicleService.addVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Vehicle saved successfully!", dto), HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateVehicle(@RequestBody VehicleDTO dto) {
        vehicleService.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Vehicle updated successfully!", dto), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicle(@RequestParam String id) {
        vehicleService.deleteVehicle(id);
        return new ResponseEntity(new StandardResponse("200", "Vehicle was deleted!!", null), HttpStatus.CREATED);
    }
}
