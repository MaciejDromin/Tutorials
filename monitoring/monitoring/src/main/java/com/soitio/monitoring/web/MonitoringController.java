package com.soitio.monitoring.web;

import com.soitio.monitoring.application.MonitoringService;
import com.soitio.monitoring.domain.ExampleObject;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MonitoringController {

    private final MonitoringService monitoringService;

    @GetMapping("/simple")
    @Timed("endpoints.simple")
    public String simple() {
        return monitoringService.monitorSimple();
    }

    @GetMapping("/queue")
    @Timed("endpoints.queue")
    public String queue() {
        return monitoringService.monitorQueue();
    }

    @PostMapping("/example")
    public ExampleObject example(@RequestBody ExampleObject object) {
        return  monitoringService.processExample(object);
    }

}
