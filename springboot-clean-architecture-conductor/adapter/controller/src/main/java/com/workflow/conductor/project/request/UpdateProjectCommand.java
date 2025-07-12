package com.workflow.conductor.project.request;

import com.workflow.conductor.domain.Project;

public class UpdateProjectCommand {
    private final long id;
    private final String name;
    private final String description;

    private UpdateProjectCommand(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Project toDomain() {
        return new Project(id, name, description);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
