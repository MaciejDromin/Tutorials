package com.soitio.gatling;

import static io.gatling.javaapi.http.HttpDsl.http;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import lombok.Getter;

public class PerformanceConfig {

    private static PerformanceConfig instance;

    @Getter
    private HttpProtocolBuilder httpProtocol;

    private PerformanceConfig() {
    }

    public static PerformanceConfig getInstance() {
        if (instance == null) {
            instance = new PerformanceConfig();
            instance.httpProtocol = http.baseUrl("http://localhost:8080")
                    .header("Content-Type", "application/json")
                    .inferHtmlResources();
        }
        return instance;
    }

}
