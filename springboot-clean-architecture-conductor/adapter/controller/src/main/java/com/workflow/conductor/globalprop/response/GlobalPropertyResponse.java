package com.workflow.conductor.globalprop.response;

import com.workflow.conductor.domain.GlobalProperty;

public class GlobalPropertyResponse {
    private final long id;
    private final String name;
    private final String value;

    private GlobalPropertyResponse(long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public static GlobalPropertyResponse from(GlobalProperty globalProperty) {
        return new GlobalPropertyResponse(
                globalProperty.getId(),
                globalProperty.getName(),
                globalProperty.getValue());
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
