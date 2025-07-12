package com.workflow.conductor.usecase.workflow;

import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

public class UpdateWorkflow {

    private final WorkflowRepository workflowRepository;

    public UpdateWorkflow(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public long updateWorkflow(Workflow workflow) {
        if (!workflow.existId()) {
            throw new IllegalArgumentException("Need to id");
        }

        return workflowRepository.update(workflow);
    }
}
