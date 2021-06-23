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

    @GetMapping(path = "/available_vehicles")
    public ResponseEntity getAllAvailableVehicles() {
        ArrayList<VehicleDTO> allVehicles = vehicleService.findAllAvailableVehicles();
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
    public ResponseEntity updateVehicleCategory(@RequestBody VehicleDTO dto) {
        vehicleService.updateVehicle(dto);
        return new ResponseEntity(new StandardResponse("200", "Vehicle category updated successfully!", dto), HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicleCategory(@RequestParam String id) {
        vehicleService.deleteVehicleCategory(id);
        return new ResponseEntity(new StandardResponse("200", "Vehicle category was deleted!!", null), HttpStatus.CREATED);
    }
}
