package com.workflow.conductor.usecase.workflow;

import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

public class DeleteWorkflow {

    private final JobPropertyRepository jobPropertyRepository;
    private final WorkflowRepository workflowRepository;

    public DeleteWorkflow(JobPropertyRepository jobPropertyRepository, WorkflowRepository workflowRepository) {
        this.jobPropertyRepository = jobPropertyRepository;
        this.workflowRepository = workflowRepository;
    }

    public void deleteWorkflow(long workflowId) {
        jobPropertyRepository.deleteByWorkflowId(workflowId);
        workflowRepository.deleteById(workflowId);
    }
}
