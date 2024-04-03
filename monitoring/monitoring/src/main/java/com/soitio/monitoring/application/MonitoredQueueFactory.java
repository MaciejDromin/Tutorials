package com.soitio.monitoring.application;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

@Component
@RequiredArgsConstructor
public class MonitoredQueueFactory {

    private final MeterRegistry meterRegistry;

    public <T> ArrayBlockingQueue<T> create(String name, int capacity) {
        ArrayBlockingQueue<T> queue = new ArrayBlockingQueue<>(capacity);

        meterRegistry.gauge("queue.%s.utilization".formatted(name), queue, q -> ((double) q.size() / (double) capacity) * 100.0);

        return queue;
    }

}
