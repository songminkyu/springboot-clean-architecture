package com.workflow.conductor.usecase.project;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.usecase.project.port.ProjectRepository;

public class CreateProject {

    private final ProjectRepository projectRepository;

    public CreateProject(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public long createProject(Project project) {
        if (project.existSpecialCharacter()) {
            throw new IllegalArgumentException("Name cannot contain special characters.");
        }

        return projectRepository.save(project);
    }
}
