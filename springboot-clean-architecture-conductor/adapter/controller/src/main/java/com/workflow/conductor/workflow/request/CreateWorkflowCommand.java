package com.workflow.conductor.workflow.request;

import com.workflow.conductor.JsonParseUtil;
import com.workflow.conductor.domain.ConductorTask;
import com.workflow.conductor.domain.Workflow;

import java.util.List;
import java.util.Map;

public class CreateWorkflowCommand {
    private final long projectId;
    private final String name;
    private final String description;
    private final List<ConductorTask> tasks;
    private final Map<String, Object> jobProperties;
    private final String ownerEmail;
    private final long timeoutSeconds;

    private CreateWorkflowCommand(
            long projectId,
            String name,
            String description,
            List<ConductorTask> tasks,
            Map<String, Object> jobProperties,
            String ownerEmail, long timeoutSeconds) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.jobProperties = jobProperties;
        this.ownerEmail = ownerEmail;
        this.timeoutSeconds = timeoutSeconds;
    }

    public Workflow toDomain() {
        return new Workflow(
                projectId,
                name,
                description,
                JsonParseUtil.parseStringJsonDefList(tasks),
                ownerEmail,
                timeoutSeconds);
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
