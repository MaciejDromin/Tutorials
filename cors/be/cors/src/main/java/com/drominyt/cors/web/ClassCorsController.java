package com.drominyt.cors.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
@CrossOrigin(origins = {"http://localhost:5173"}, maxAge = 3600)
public class ClassCorsController {

    @GetMapping
    public ReponseWrapper getExample() {
        return new ReponseWrapper("Im from class controller");
    }

}
