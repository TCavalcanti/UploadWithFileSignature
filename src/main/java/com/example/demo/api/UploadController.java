package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.response.UploadDto;
import com.example.demo.service.impl.FilesUploadService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController(value = "")
public class UploadController {
  

    @Autowired
    private FilesUploadService filesUploadService;

    @PostMapping(value = "/upload")
    public ResponseEntity<UploadDto> upload(@RequestParam MultipartFile files[]){

        log.info("#init upload");

        UploadDto responseDto = filesUploadService.upload(files);

        log.info("#finish upload");

        return ResponseEntity.ok(responseDto);


    }
    

}
