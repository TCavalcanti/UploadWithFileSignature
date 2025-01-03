package com.example.demo.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UploadDto {

    List<String> success;
    List<String> errors;
    
}

