package pl.mlisowski.testing.example.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mlisowski.testing.example.domain.ComplexClass;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final DummyService dummyService;

    public ComplexClass update(ComplexClass complexClass) {
        return complexClass.toBuilder()
                .subComplexClass(complexClass.getSubComplexClass().toBuilder()
                        .test(dummyService.dummy())
                        .build())
                .build();
    }

    public int simpleCalculations(int... vars) {
        int ret = 0;
        for (int v : vars) {
            ret += v;
        }
        return ret;
    }

}
