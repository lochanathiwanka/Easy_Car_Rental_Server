package com.locha.controller;

import com.locha.dto.CustomeDTO;
import com.locha.dto.RequestDTO;
import com.locha.service.RequestService;
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
import java.util.ArrayList;

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

            InputStream inputStream = image.getInputStream();
            Path path = Paths.get("/home/locha/Documents/Easy_Car_Rental_Storage/bank_slips/");

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

    @GetMapping("/get_image/{image}")
    public void getBankSlipImage(@PathVariable String image, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg;charset=utf-8");
        response.setHeader("Content-Disposition", "inline; filename=girls.png");

        ServletOutputStream outputStream = response.getOutputStream();

        String path = "/home/locha/Documents/Easy_Car_Rental_Storage/bank_slips/";

        outputStream.write(Files.readAllBytes(Paths.get(path).resolve(image)));
        outputStream.flush();
        outputStream.close();
    }

    @GetMapping(path = "/lastrid")
    public ResponseEntity getLastRid() {
        String lastRid = requestService.getLastRid();
        return new ResponseEntity(new StandardResponse("200", "Done", lastRid), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getAllRequests() {
        ArrayList<RequestDTO> all = requestService.getAllRequests();
        return new ResponseEntity(new StandardResponse("200", "Done", all), HttpStatus.OK);
    }

    @GetMapping(path = "/get_request", params = {"cid"})
    public ResponseEntity getRequestByCid(String cid) {
        ArrayList<RequestDTO> request = requestService.findRequestByCid(cid);
        return new ResponseEntity(new StandardResponse("200", "Done", request), HttpStatus.OK);
    }


    //test
    @GetMapping(path = "/get")
    public ResponseEntity test() {
        ArrayList<CustomeDTO> test = requestService.test("V001");
        return new ResponseEntity(new StandardResponse("200", "Done", test), HttpStatus.OK);
    }


    @DeleteMapping(path = "delete_request", params = {"rid"})
    public ResponseEntity deleteRequestDetails(@RequestParam String rid) {
        requestService.deleteRequestDetails(rid);
        return new ResponseEntity(new StandardResponse("200", "Request deleted!", null), HttpStatus.OK);
    }

}
