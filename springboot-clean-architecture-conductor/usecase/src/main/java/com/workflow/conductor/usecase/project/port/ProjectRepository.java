package com.workflow.conductor.usecase.project.port;

import com.workflow.conductor.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    Optional<Project> findById(long id);

    List<Project> findAll();

    long save(Project project);

    long update(Project project);

    void deleteById(long id);
}
