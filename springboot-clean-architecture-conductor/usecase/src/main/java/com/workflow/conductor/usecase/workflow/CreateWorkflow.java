package com.workflow.conductor.usecase.workflow;

import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

public class CreateWorkflow {

    private final WorkflowRepository workflowRepository;

    public CreateWorkflow(WorkflowRepository workflowRepository) {
        this.workflowRepository = workflowRepository;
    }

    public long createWorkflow(Workflow workflow) {
        if (workflow.existSpecialCharacter()) {
            throw new IllegalArgumentException("Name cannot contain special characters.");
        }

        return workflowRepository.save(workflow);
    }
}
