package com.drominyt.imagesaving.example.web;

import com.drominyt.imagesaving.example.application.ExampleUserService;
import com.drominyt.imagesaving.example.application.StorageService;
import com.drominyt.imagesaving.example.domain.dto.ExampleUserDto;
import com.drominyt.imagesaving.example.domain.dto.FileCreatedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ExampleController {

    private final ExampleUserService exampleUserService;
    private final StorageService storageService;

    @GetMapping
    public List<ExampleUserDto> getAllUsers() {
        return exampleUserService.getUsers();
    }

    @PostMapping
    public ExampleUserDto createUser(@RequestBody ExampleUserDto exampleUserDto) {
        return exampleUserService.createUser(exampleUserDto);
    }

    @PutMapping("/images")
    public FileCreatedDto uploadImage(@RequestParam("file")MultipartFile file) {
        return FileCreatedDto.of(storageService.saveFile(file));
    }

}
