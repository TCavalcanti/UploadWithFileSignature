package com.example.demo.service.impl;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.response.UploadDto;

public interface FileUploadService {

   UploadDto upload(MultipartFile files[]);
    
} 