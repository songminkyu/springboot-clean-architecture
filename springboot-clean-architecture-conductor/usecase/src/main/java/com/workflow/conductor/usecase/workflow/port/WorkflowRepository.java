package com.workflow.conductor.usecase.workflow.port;

import com.workflow.conductor.domain.Workflow;

import java.util.List;
import java.util.Optional;

public interface WorkflowRepository {

    Optional<Workflow> findById(long workflowId);

    List<Workflow> findAllByProjectId(long projectId);

    long save(Workflow workflow);

    long update(Workflow workflow);

    void deleteById(long workflowId);
}
