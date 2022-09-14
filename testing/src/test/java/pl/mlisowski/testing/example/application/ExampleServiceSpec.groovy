package pl.mlisowski.testing.example.application

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class ExampleServiceSpec extends Specification {

    DummyService dummyService = Mock()

    @Subject
    ExampleService exampleService = new ExampleService(dummyService)

    @Unroll
    def "Should properly calculate sum"() {
        when:
        def result = exampleService.simpleCalculations(numsToSum)
        then:
        result == expectedResult
        where:
        numsToSum           || expectedResult
        new int[]{1,2}      || 3
        new int[]{}         || 0
        new int[]{-3,-4}    || -7
        new int[]{-3,-4,5}  || -2
    }

}
