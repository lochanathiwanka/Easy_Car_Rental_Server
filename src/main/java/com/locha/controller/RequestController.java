package com.locha.controller;

import com.locha.dto.RequestDTO;
import com.locha.service.RequestService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    @PostMapping(path = "/upload_bank_slip", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadBankSlip(@RequestPart("bankSlip") MultipartFile image) {
        try {
            String file_name = image.getOriginalFilename();
            String[] split = file_name.split("-", 2);

            InputStream inputStream = image.getInputStream();
            Path path = Paths.get("/home/locha/Documents/Easy_Car_Rental_Storage/bank_slips/" + split[0]);

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            Files.copy(inputStream, path.resolve(file_name));
            return new ResponseEntity(new StandardResponse("200", "Image Uploaded", null), HttpStatus.CREATED);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(new StandardResponse("200", "Error", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "lastrid")
    public ResponseEntity getLastRid() {
        String lastRid = requestService.getLastRid();
        return new ResponseEntity(new StandardResponse("200", "Done", lastRid), HttpStatus.CREATED);
    }

}
