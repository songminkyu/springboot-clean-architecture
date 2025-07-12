package com.workflow.conductor.project;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.project.request.CreateProjectCommand;
import com.workflow.conductor.project.request.UpdateProjectCommand;
import com.workflow.conductor.project.response.ProjectResponse;
import com.workflow.conductor.usecase.project.CreateProject;
import com.workflow.conductor.usecase.project.DeleteProject;
import com.workflow.conductor.usecase.project.FindProject;
import com.workflow.conductor.usecase.project.UpdateProject;

import java.util.List;

public class ProjectController {

    private final FindProject findProject;
    private final CreateProject createProject;
    private final UpdateProject updateProject;
    private final DeleteProject deleteProject;

    public ProjectController(FindProject findProject, CreateProject createProject, UpdateProject updateProject, DeleteProject deleteProject) {
        this.findProject = findProject;
        this.createProject = createProject;
        this.updateProject = updateProject;
        this.deleteProject = deleteProject;
    }

    public ProjectResponse getProject(long id) {
        Project project = findProject.getProject(id);
        return ProjectResponse.from(project);
    }

    public List<ProjectResponse> getAllProjects() {
        List<Project> projects = findProject.getAllProjects();
        return projects.stream()
                .map(ProjectResponse::from)
                .toList();
    }

    public long createProject(CreateProjectCommand command) {
        return createProject.createProject(command.toDomain());
    }

    public long updateProject(UpdateProjectCommand command) {
        return updateProject.updateProject(command.toDomain());
    }

    public void deleteProject(long id) {
        deleteProject.deleteProject(id);
    }
}
