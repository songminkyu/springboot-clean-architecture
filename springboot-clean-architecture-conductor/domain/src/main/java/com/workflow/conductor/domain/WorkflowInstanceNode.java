package com.workflow.conductor.domain;

import java.time.LocalDateTime;

public class WorkflowInstanceNode {
    private long id;

    private long workflowInstanceId;

    private NodeType nodeType;

    private String name;

    private String description;

    private String jsonDefinition;

    private String engineTaskInstanceId;

    private WorkflowNodeStatus workflowNodeStatus;

    private LocalDateTime createTime;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private LocalDateTime modifiedTime;

    /**
     * For create workflowInstance
     */
    public WorkflowInstanceNode(long workflowInstanceId, NodeType nodeType, String name, String description, String jsonDefinition, String engineTaskInstanceId, WorkflowNodeStatus workflowNodeStatus) {
        LocalDateTime now = LocalDateTime.now();
        this.workflowInstanceId = workflowInstanceId;
        this.nodeType = nodeType;
        this.name = name;
        this.description = description;
        this.jsonDefinition = jsonDefinition;
        this.engineTaskInstanceId = engineTaskInstanceId;
        this.workflowNodeStatus = workflowNodeStatus;
        this.createTime = now;
        this.modifiedTime = now;
    }

    public long getId() {
        return id;
    }

    public long getWorkflowInstanceId() {
        return workflowInstanceId;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public String getEngineTaskInstanceId() {
        return engineTaskInstanceId;
    }

    public WorkflowNodeStatus getWorkflowNodeStatus() {
        return workflowNodeStatus;
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
