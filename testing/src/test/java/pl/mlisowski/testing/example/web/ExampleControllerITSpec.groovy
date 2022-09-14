package pl.mlisowski.testing.example.web

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import pl.mlisowski.testing.BaseITSpec
import pl.mlisowski.testing.example.domain.ComplexClass
import pl.mlisowski.testing.example.domain.SubComplexClass

@AutoConfigureMockMvc
class ExampleControllerITSpec extends BaseITSpec {

    @Autowired
    MockMvc mockMvc

    @Autowired
    ObjectMapper objectMapper

    def "Should properly update ComplexClass"(){
        given:
        def complex = ComplexClass.builder()
                .name("test")
                .subComplexClass(SubComplexClass.builder()
                        .name("subTest")
                        .test("testing")
                        .build())
                .build()
        when:
        def response = objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.post("/example")
                .content(objectMapper.writeValueAsString(complex))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .response
                .contentAsString, ComplexClass.class)
        then:
        with(response) {
            name == "test"
            with(subComplexClass) {
                name == "subTest"
                test == "Hello!"
            }
        }
    }

    def "Should properly get ComplexClass"(){
        when:
        def response = objectMapper.readValue(mockMvc.perform(MockMvcRequestBuilders.get("/example"))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .response
                .contentAsString, ComplexClass.class)
        then:
        with(response) {
            name == "test"
            with(subComplexClass) {
                name == "testSub"
                test == "Sub"
            }
        }
    }

}
