package com.workflow.conductor.project.response;

import com.workflow.conductor.domain.Project;

public class ProjectResponse {
    private final long id;
    private final String name;
    private final String description;

    private ProjectResponse(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static ProjectResponse from(Project project) {
        return new ProjectResponse(project.getId() , project.getName(), project.getDescription());
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
