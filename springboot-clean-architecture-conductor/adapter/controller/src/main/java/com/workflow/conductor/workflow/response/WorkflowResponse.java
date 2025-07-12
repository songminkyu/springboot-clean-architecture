package com.workflow.conductor.workflow.response;

import com.workflow.conductor.JsonParseUtil;
import com.workflow.conductor.PropertyUtil;
import com.workflow.conductor.domain.ConductorTask;
import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.domain.Workflow;

import java.util.List;
import java.util.Map;

public class WorkflowResponse {
    private final long id;
    private final long projectId;
    private final String name;
    private final String description;
    private final List<ConductorTask> tasks;
    private final Map<String, Object> jobProperties;
    private final String ownerEmail;
    private final long timeoutSeconds;

    public WorkflowResponse(
            long id,
            long projectId,
            String name,
            String description,
            List<ConductorTask> tasks,
            Map<String, Object> jobProperties,
            String ownerEmail,
            long timeoutSeconds) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.jobProperties = jobProperties;
        this.ownerEmail = ownerEmail;
        this.timeoutSeconds = timeoutSeconds;
    }

    public static WorkflowResponse from(Workflow workflow, List<JobProperty> jobProperties) {
        return new WorkflowResponse(
                workflow.getId(),
                workflow.getProjectId(),
                workflow.getName(),
                workflow.getDescription(),
                JsonParseUtil.parseTasks(workflow.getJsonDefinition()),
                PropertyUtil.parseJobProperties(jobProperties),
                workflow.getOwnerMail(),
                workflow.getTimeoutSeconds());
    }

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ConductorTask> getTasks() {
        return tasks;
    }

    public Map<String, Object> getJobProperties() {
        return jobProperties;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public long getTimeoutSeconds() {
        return timeoutSeconds;
    }
}
