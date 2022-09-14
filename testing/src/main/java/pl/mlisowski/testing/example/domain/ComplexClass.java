package pl.mlisowski.testing.example.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ComplexClass {

    String name;
    SubComplexClass subComplexClass;

}
