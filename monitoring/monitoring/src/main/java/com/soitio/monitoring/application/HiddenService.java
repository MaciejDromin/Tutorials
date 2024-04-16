package com.soitio.monitoring.application;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import com.soitio.monitoring.domain.ExampleObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HiddenService {

    private static final Random random = new Random();
    private static AtomicInteger requestCount = new AtomicInteger(0);
    private static AtomicInteger exampleCount = new AtomicInteger(0);

    public void runSecretCode() {
        if (requestCount.incrementAndGet() > 50) {
            try {
                Thread.sleep(random.nextInt(6900, 15000));
            } catch (InterruptedException e) {
                log.error("Could not sleep thread {}", e.getMessage());
            }
            requestCount.setPlain(0);
        }
    }

    public ExampleObject processExample(ExampleObject object) {
        object.setStatus(ExampleObject.ExampleEnum.WORKING);
        if (exampleCount.incrementAndGet() > 50) {
            object.setStatus(ExampleObject.ExampleEnum.LAZY);
            exampleCount.setPlain(0);
        }
        return object;
    }
}
