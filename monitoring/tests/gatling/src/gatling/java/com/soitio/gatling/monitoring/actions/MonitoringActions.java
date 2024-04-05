package com.soitio.gatling.monitoring.actions;

import static io.gatling.javaapi.http.HttpDsl.http;

import io.gatling.javaapi.core.CoreDsl;
import io.gatling.javaapi.http.HttpRequestActionBuilder;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MonitoringActions {

    public static final String TEST_SIMPLE = "test simple endpoint";
    public static final String TEST_EXAMPLE = "test example endpoint";

    public static final HttpRequestActionBuilder TEST_SIMPLE_ACTION = http(TEST_SIMPLE)
            .get("/simple");

    public static final HttpRequestActionBuilder TEST_EXAMPLE_ACTION = http(TEST_EXAMPLE)
            .post("/example")
            .body(CoreDsl.ElFileBody("monitoring/exampleTemplate.json"));

}
