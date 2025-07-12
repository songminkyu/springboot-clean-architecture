package com.workflow.conductor.usecase.workflow;

import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class FindWorkflow {

    private final WorkflowRepository workflowRepository;

    public FindWorkflow(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public Workflow getWorkflow(long workflowId) {
        return workflowRepository.findById(workflowId)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Workflow> getWorkflowsInProject(long projectId) {
        return workflowRepository.findAllByProjectId(projectId);
    }
}
