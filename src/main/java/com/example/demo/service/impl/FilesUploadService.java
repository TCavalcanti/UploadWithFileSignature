package com.example.demo.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.response.UploadDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FilesUploadService  implements FileUploadService{

    char[] PNG_SIGNATURE = {137, 80, 78, 71, 13, 10, 26, 10};

    @Override
    public UploadDto upload(MultipartFile[] files) {

        List<String> success = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        log.info("### FilesUploadService -> upload");

        for(MultipartFile file : files){
            try {

                byte[] bytes = file.getBytes();
                byte[] chunk = Arrays.copyOfRange(bytes, 0, 8);

                char[] signature = new String(chunk, StandardCharsets.ISO_8859_1).toCharArray();

                if(Arrays.equals(PNG_SIGNATURE, signature)){
                    success.add(file.getOriginalFilename());   
                }else{
                    errors.add(file.getOriginalFilename() + " # Assinatura inválida");
                }

                log.info("### fim leitura file {}", file.getOriginalFilename());

            } catch (Exception e) {
                errors.add(file.getOriginalFilename() + " # Erro ao abrir");
            }
        }

        return UploadDto.builder()
        .success(success)
        .errors(errors)
        .build();
    }
    
}
