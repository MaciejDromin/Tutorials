package com.soitio.gatling.monitoring.scenarios;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.details;
import static io.gatling.javaapi.core.CoreDsl.during;
import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.jsonPath;
import static io.gatling.javaapi.core.CoreDsl.pace;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.core.CoreDsl.tryMax;

import com.soitio.gatling.PerformanceConfig;
import com.soitio.gatling.monitoring.actions.MonitoringActions;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Session;
import io.gatling.javaapi.core.Simulation;
import java.time.Duration;
import java.util.Random;

public class ExampleScenario extends Simulation {

    private static final Random RANDOM = new Random();

    private static Session setSessionAttr(Session session) {
        return session.set("exampleName", "test-%d".formatted(RANDOM.nextInt(1, 300)))
                .set("exampleCount", RANDOM.nextInt(1, 69));
    }

    public static final ScenarioBuilder EXAMPLE = scenario("example scenario")
            .exec(during(Duration.ofMinutes(2))
                    .on(pace(Duration.ofSeconds(10))
                            .exec(ExampleScenario::setSessionAttr)
                            .exec(tryMax(10)
                                    .on(exec(MonitoringActions.TEST_EXAMPLE_ACTION
                                            .check(jsonPath("$.status").is("WORKING")))))));

    {
        setUp(EXAMPLE.injectOpen(atOnceUsers(1)))
                .assertions(details(MonitoringActions.TEST_EXAMPLE).successfulRequests().percent().is(100d))
                .protocols(PerformanceConfig.getInstance().getHttpProtocol());
    }

}
