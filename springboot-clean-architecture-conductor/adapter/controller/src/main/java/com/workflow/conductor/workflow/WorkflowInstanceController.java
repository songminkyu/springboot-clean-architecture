package com.workflow.conductor.workflow;

import com.workflow.conductor.usecase.workflow.RunWorkflow;

public class WorkflowInstanceController {

    private final RunWorkflow runWorkflow;

    public WorkflowInstanceController(RunWorkflow runWorkflow) {
        this.runWorkflow = runWorkflow;
    }

    public long runWorkflow(long workflowId) {
        return runWorkflow.runWorkflow(workflowId);
    }
}
