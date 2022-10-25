package com.drominyt.imagesaving.example.application;

import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageService {

    private static final String UPLOAD_DIRECTORY_PATH = System.getProperty("user.dir") + "/build/resources/main/static/images";

    @SneakyThrows
    public String saveFile(MultipartFile file) {
        String fileName = RandomStringUtils.randomAlphanumeric(5) + ".png";
        Path path = Paths.get(UPLOAD_DIRECTORY_PATH, fileName);
        String url = "http://localhost:8080/images/%s".formatted(fileName);
        Files.write(path, file.getBytes());
        return url;
    }

}
