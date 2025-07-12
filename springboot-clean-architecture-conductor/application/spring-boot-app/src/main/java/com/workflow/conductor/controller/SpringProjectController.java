package com.workflow.conductor.controller;

import com.workflow.conductor.project.ProjectController;
import com.workflow.conductor.project.request.CreateProjectCommand;
import com.workflow.conductor.project.request.UpdateProjectCommand;
import com.workflow.conductor.project.response.ProjectResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workflow.conductor.RequestMappingConstants.PROJECT;

@RestController
@RequestMapping(PROJECT)
public class SpringProjectController {

    private final ProjectController projectController;

    public SpringProjectController(ProjectController projectController) {
        this.projectController = projectController;
    }

    @GetMapping("{id}")
    ProjectResponse getProject(@PathVariable long id) {
        return projectController.getProject(id);
    }

    @GetMapping
    List<ProjectResponse> getAllProjects() {
        return projectController.getAllProjects();
    }

    @PostMapping
    long createProject(@RequestBody CreateProjectCommand command) {
        return projectController.createProject(command);
    }

    @PutMapping
    long updateProject(@RequestBody UpdateProjectCommand command) {
        return projectController.updateProject(command);
    }

    @DeleteMapping("{id}")
    void deleteProject(@PathVariable("id") long id) {
        projectController.deleteProject(id);
    }
}
