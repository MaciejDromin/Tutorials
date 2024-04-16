package com.soitio.monitoring.application;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;

import com.soitio.monitoring.domain.ExampleObject;
import org.springframework.stereotype.Service;

@Service
public class MonitoringService {

    private final HiddenService hiddenService;
    private final ArrayBlockingQueue<String> monitoredQueue;

    public MonitoringService(HiddenService hiddenService, MonitoredQueueFactory monitoredQueueFactory) {
        this.hiddenService = hiddenService;
        this.monitoredQueue = monitoredQueueFactory.create("demo", 69);
    }

    public String monitorSimple() {
        hiddenService.runSecretCode();
        return "simple";
    }

    public String monitorQueue() {
        this.monitoredQueue.add(UUID.randomUUID().toString()); // process items from queue
        return "queue";
    }

    public ExampleObject processExample(ExampleObject object) {
        return hiddenService.processExample(object);
    }
}
