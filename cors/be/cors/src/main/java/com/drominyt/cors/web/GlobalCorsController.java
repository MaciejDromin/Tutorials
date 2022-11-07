package com.drominyt.cors.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/global")
public class GlobalCorsController {

    @GetMapping
    public ReponseWrapper getExample() {
        return new ReponseWrapper("Im from global controller");
    }

}
