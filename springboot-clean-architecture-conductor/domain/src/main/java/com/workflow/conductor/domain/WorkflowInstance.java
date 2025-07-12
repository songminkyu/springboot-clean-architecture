package com.workflow.conductor.domain;

import java.time.LocalDateTime;

public class WorkflowInstance {
    private long id;

    private long workflowId;

    private String jsonDefinition;

    private String engineWorkflowInstanceId;

    private WorkflowStatus workflowStatus;

    private LocalDateTime createTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime modifiedTime;

    /**
     * Start workflow
     */
    public WorkflowInstance(long workflowId, String jsonDefinition, String engineWorkflowInstanceId, WorkflowStatus workflowStatus) {
        LocalDateTime now = LocalDateTime.now();
        this.workflowId = workflowId;
        this.jsonDefinition = jsonDefinition;
        this.engineWorkflowInstanceId = engineWorkflowInstanceId;
        this.workflowStatus = workflowStatus;
        this.createTime = now;
        this.modifiedTime = now;
    }

    public long getId() {
        return id;
    }

    public long getWorkflowId() {
        return workflowId;
    }

    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public String getEngineWorkflowInstanceId() {
        return engineWorkflowInstanceId;
    }

    public WorkflowStatus getWorkflowStatus() {
        return workflowStatus;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }
}
