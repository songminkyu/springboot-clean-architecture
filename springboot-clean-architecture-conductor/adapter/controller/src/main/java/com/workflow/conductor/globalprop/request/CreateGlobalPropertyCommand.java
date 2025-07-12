package com.workflow.conductor.globalprop.request;

import com.workflow.conductor.domain.GlobalProperty;

public class CreateGlobalPropertyCommand {
    private final String name;
    private final String value;

    private CreateGlobalPropertyCommand(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public GlobalProperty toDomain() {
        return new GlobalProperty(name, value);
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
