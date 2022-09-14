package pl.mlisowski.testing.example.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.mlisowski.testing.example.application.ExampleService;
import pl.mlisowski.testing.example.domain.ComplexClass;
import pl.mlisowski.testing.example.domain.SubComplexClass;

@RestController
@RequestMapping("/example")
@RequiredArgsConstructor
public class ExampleController {

    private final ExampleService exampleService;

    @GetMapping
    public ComplexClass complexClass() {
        return ComplexClass.builder()
                .name("test")
                .subComplexClass(SubComplexClass.builder()
                        .name("testSub")
                        .test("Sub")
                        .build())
                .build();
    }

    @PostMapping
    public ComplexClass complexClassPost(@RequestBody ComplexClass complexClass) {
        return exampleService.update(complexClass);
    }

}
