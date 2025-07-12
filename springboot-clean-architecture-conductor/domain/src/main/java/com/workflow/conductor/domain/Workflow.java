package com.workflow.conductor.domain;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class Workflow {

    private final Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

    private long id;

    private long projectId;

    private String name;

    private String description;

    private String jsonDefinition;

    private String ownerMail;

    private long timeoutSeconds;

    private LocalDateTime createTime;

    private LocalDateTime modifiedTime;

    /**
     * For get workflow
     */
    public Workflow(long id, long projectId, String name, String description, String jsonDefinition, String ownerMail, long timeoutSeconds, LocalDateTime createTime, LocalDateTime modifiedTime) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.jsonDefinition = jsonDefinition;
        this.ownerMail = ownerMail;
        this.timeoutSeconds = timeoutSeconds;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

    /**
     * * For create workflow
     */
    public Workflow(long projectId, String name, String description, String jsonDefinition, String ownerMail, long timeoutSeconds) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.jsonDefinition = jsonDefinition;
        this.ownerMail = ownerMail;
        this.timeoutSeconds = timeoutSeconds;
        LocalDateTime now = LocalDateTime.now();
        this.createTime = now;
        this.modifiedTime = now;
    }

    /**
     * * For update workflow
     */
    public Workflow(long id, long projectId, String name, String description, String jsonDefinition, String ownerMail, long timeoutSeconds) {
        this.id = id;
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.jsonDefinition = jsonDefinition;
        this.ownerMail = ownerMail;
        this.timeoutSeconds = timeoutSeconds;
        this.modifiedTime = LocalDateTime.now();
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

    public String getJsonDefinition() {
        return jsonDefinition;
    }

    public String getOwnerMail() {
        return ownerMail;
    }

    public long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public boolean existSpecialCharacter() {
        return specialCharacterPattern.matcher(name).find();
    }

    public boolean existId() {
        return this.id != 0;
    }

    public boolean equalProject(long projectId) {
        return this.projectId == projectId;
    }
}
