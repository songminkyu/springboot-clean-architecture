package com.workflow.conductor.usecase.project;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.usecase.project.port.ProjectRepository;

public class UpdateProject {

    private final ProjectRepository projectRepository;

    public UpdateProject(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public long updateProject(Project project) {
        if (!project.existId()) {
            throw new IllegalArgumentException("Need to id");
        }
        return projectRepository.update(project);
    }
}
