package com.drominyt.imagesaving.example.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Builder
public class FileCreatedDto {

    private String url;

}
