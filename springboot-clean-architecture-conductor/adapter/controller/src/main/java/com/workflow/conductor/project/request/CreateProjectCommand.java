package com.workflow.conductor.project.request;

import com.workflow.conductor.domain.Project;

public class CreateProjectCommand {
    private final String name;
    private final String description;

    private CreateProjectCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Project toDomain() {
        return new Project(name, description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
