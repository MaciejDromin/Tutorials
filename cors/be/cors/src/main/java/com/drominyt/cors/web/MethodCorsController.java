package com.drominyt.cors.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cors")
public class MethodCorsController {

    @GetMapping
    @CrossOrigin(origins = {"http://localhost:5173"})
    public ReponseWrapper getExample() {
        return new ReponseWrapper("Im from method controller");
    }

}
