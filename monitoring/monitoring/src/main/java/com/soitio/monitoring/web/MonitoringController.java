package com.soitio.monitoring.web;

import com.soitio.monitoring.application.MonitoringService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

}
