package com.drominyt.imagesaving.example.domain.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ExampleUserDto {

    private Long id;
    private String uuid;
    private String name;
    private String imgSrc;

}
