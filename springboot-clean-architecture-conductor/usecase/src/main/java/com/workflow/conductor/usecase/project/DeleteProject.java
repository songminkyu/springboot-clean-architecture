package com.workflow.conductor.usecase.project;

import com.workflow.conductor.usecase.project.port.ProjectRepository;

public class DeleteProject {

    private final ProjectRepository projectRepository;

    public DeleteProject(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }
}
