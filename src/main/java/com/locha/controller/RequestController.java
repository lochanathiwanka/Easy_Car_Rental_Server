package com.locha.controller;

import com.locha.dto.RequestDTO;
import com.locha.service.RequestService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
@CrossOrigin
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping
    public ResponseEntity postRequest(@RequestBody RequestDTO dto) {
        requestService.addRequest(dto);
        return new ResponseEntity(new StandardResponse("200", "Request has been sent", dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "lastrid")
    public ResponseEntity getLastRid() {
        String lastRid = requestService.getLastRid();
        return new ResponseEntity(new StandardResponse("200", "Done", lastRid), HttpStatus.CREATED);
    }

}
