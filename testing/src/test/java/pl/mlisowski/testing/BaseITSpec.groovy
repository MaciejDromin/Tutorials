package pl.mlisowski.testing

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import spock.lang.Specification

@AutoConfigureWireMock(port = 0)
@SpringBootTest(classes = [SpockTestingApplication])
abstract class BaseITSpec extends Specification {
}
