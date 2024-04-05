package com.soitio.monitoring.domain;

import lombok.Data;

@Data
public class ExampleObject {

    private String name;
    private int count;
    private ExampleEnum status;

    public enum ExampleEnum {
        WORKING,
        LAZY
    }

}
