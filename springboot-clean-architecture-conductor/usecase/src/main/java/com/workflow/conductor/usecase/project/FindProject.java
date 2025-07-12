package com.workflow.conductor.usecase.project;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.usecase.project.port.ProjectRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class FindProject {

    private final ProjectRepository projectRepository;

    public FindProject(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project getProject(long id) {
        return projectRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
