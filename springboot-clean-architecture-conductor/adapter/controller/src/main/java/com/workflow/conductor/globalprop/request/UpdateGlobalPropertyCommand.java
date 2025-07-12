package com.workflow.conductor.globalprop.request;

import com.workflow.conductor.domain.GlobalProperty;

public class UpdateGlobalPropertyCommand {
    private final long id;
    private final String name;
    private final String value;

    private UpdateGlobalPropertyCommand(long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public GlobalProperty toDomain() {
        return new GlobalProperty(id, name, value);
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
