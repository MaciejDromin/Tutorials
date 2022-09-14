package pl.mlisowski.testing.example.application

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import pl.mlisowski.testing.BaseITSpec
import pl.mlisowski.testing.example.domain.ComplexClass
import pl.mlisowski.testing.example.domain.SubComplexClass
import spock.lang.Subject

class ExampleServiceITSpec extends BaseITSpec {

    @SpringBean
    DummyService dummyService = Mock()

    @Autowired
    @Subject
    ExampleService exampleService

    def "Should properly update ComplexClass"(){
        given:
        def complex = ComplexClass.builder()
                .name("test")
                .subComplexClass(SubComplexClass.builder()
                        .name("subTest")
                        .test("testing")
                        .build())
                .build()
        dummyService.dummy() >> "Mocked method!"
        when:
        def result = exampleService.update(complex)
        then:
        with(result) {
            name == "test"
            with(subComplexClass) {
                name == "subTest"
                test == "Mocked method!"
            }
        }
    }

}
