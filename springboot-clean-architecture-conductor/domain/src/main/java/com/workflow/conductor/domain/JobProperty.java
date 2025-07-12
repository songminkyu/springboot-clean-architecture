package com.workflow.conductor.domain;

public class JobProperty {

    private Long id;

    private Long workflowId;

    private String name;

    private String value;

    public JobProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public JobProperty(Long id, Long workflowId, String name, String value) {
        this.id = id;
        this.workflowId = workflowId;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setId(long id) {
        this.id = id;
    }
}
