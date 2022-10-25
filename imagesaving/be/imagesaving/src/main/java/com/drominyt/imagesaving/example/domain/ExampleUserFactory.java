package com.drominyt.imagesaving.example.domain;

import com.drominyt.imagesaving.example.domain.dto.ExampleUserDto;
import org.springframework.stereotype.Component;

@Component
public class ExampleUserFactory {

    public ExampleUser from(ExampleUserDto exampleUserDto) {
        return ExampleUser.builder()
                .name(exampleUserDto.getName())
                .imgSrc(exampleUserDto.getImgSrc())
                .build();
    }

    public ExampleUserDto to(ExampleUser exampleUser) {
        return ExampleUserDto.builder()
                .id(exampleUser.getId())
                .uuid(exampleUser.getUuid())
                .name(exampleUser.getName())
                .imgSrc(exampleUser.getImgSrc())
                .build();
    }

}
