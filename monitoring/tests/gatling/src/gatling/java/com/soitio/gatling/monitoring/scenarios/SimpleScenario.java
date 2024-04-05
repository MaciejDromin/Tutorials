package com.soitio.gatling.monitoring.scenarios;

import static io.gatling.javaapi.core.CoreDsl.atOnceUsers;
import static io.gatling.javaapi.core.CoreDsl.details;
import static io.gatling.javaapi.core.CoreDsl.during;
import static io.gatling.javaapi.core.CoreDsl.pace;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import com.soitio.gatling.PerformanceConfig;
import com.soitio.gatling.monitoring.actions.MonitoringActions;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import java.time.Duration;

public class SimpleScenario extends Simulation {

    public static final ScenarioBuilder SIMPLE = scenario("simple scenario")
            .exec(during(Duration.ofMinutes(2))
                    .on(pace(Duration.ofSeconds(1))
                            .exec(MonitoringActions.TEST_SIMPLE_ACTION)));

    {
        setUp(SIMPLE.injectOpen(atOnceUsers(10)))
                .assertions(details(MonitoringActions.TEST_SIMPLE).successfulRequests().percent().is(100d))
                .protocols(PerformanceConfig.getInstance().getHttpProtocol());
    }

}
