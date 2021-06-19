package com.locha.controller;

import com.locha.service.VehicleDetailService;
import com.locha.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/vehicle_detail")
@CrossOrigin
public class VehicleDetailController {

    @Autowired
    private VehicleDetailService vehicleDetailService;


    @GetMapping(path = "/lastid")
    public ResponseEntity getLastVdid() {
        String lastVDID = vehicleDetailService.getLastVDID();
        return new ResponseEntity(new StandardResponse("200", "Done", lastVDID), HttpStatus.CREATED);
    }

    @GetMapping(path = "/get_images")
    public void getImages(HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");

        ServletOutputStream outputStream = response.getOutputStream();

        String path = "/home/locha/Documents/Easy_Car_Rental_Storage/vehicles/VD001";

        outputStream.write(Files.readAllBytes(Paths.get(path).resolve("VD001-image1")));
        outputStream.flush();
        outputStream.close();
    }

    @PostMapping(path = "/upload_images", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity uploadPhotos(@RequestPart("image") MultipartFile image) {
        try {
            String file_name = image.getOriginalFilename();
            String[] split = file_name.split("-", 2);

            InputStream inputStream = image.getInputStream();
            Path path = Paths.get("/home/locha/Documents/Easy_Car_Rental_Storage/vehicles/" + split[0]);

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

}
