package com.workflow.conductor.controller;

import com.workflow.conductor.workflow.WorkflowInstanceController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.workflow.conductor.RequestMappingConstants.WORKFLOW_INSTANCE;

@RestController
@RequestMapping(WORKFLOW_INSTANCE)
public class SpringWorkflowInstanceController {

    private final WorkflowInstanceController workflowInstanceController;

    public SpringWorkflowInstanceController(WorkflowInstanceController workflowInstanceController) {
        this.workflowInstanceController = workflowInstanceController;
    }

    @PostMapping("{workflowId}")
    public long runWorkflow(@PathVariable("workflowId") long workflowId) {
        return workflowInstanceController.runWorkflow(workflowId);
    }
}
