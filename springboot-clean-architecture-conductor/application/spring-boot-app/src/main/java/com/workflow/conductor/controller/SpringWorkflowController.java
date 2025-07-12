package com.workflow.conductor.controller;

import com.workflow.conductor.workflow.WorkflowController;
import com.workflow.conductor.workflow.request.CreateWorkflowCommand;
import com.workflow.conductor.workflow.request.UpdateWorkflowCommand;
import com.workflow.conductor.workflow.response.WorkflowResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workflow.conductor.RequestMappingConstants.WORKFLOW;

@RestController
@RequestMapping(WORKFLOW)
public class SpringWorkflowController {

    private final WorkflowController workflowController;

    public SpringWorkflowController(WorkflowController workflowController) {
        this.workflowController = workflowController;
    }

    @GetMapping("{id}")
    WorkflowResponse getWorkflow(@PathVariable("id") long workflowId) {
        return workflowController.getWorkflow(workflowId);
    }

    @GetMapping("project/{id}")
    List<WorkflowResponse> getWorkflowInProject(@PathVariable("id") long projectId) {
        return workflowController.getWorkflowInProject(projectId);
    }

    @PostMapping
    long createWorkflow(@RequestBody CreateWorkflowCommand command) {
        return workflowController.createWorkflow(command);
    }

    @PutMapping
    long updateWorkflow(@RequestBody UpdateWorkflowCommand command) {
        return workflowController.updateWorkflow(command);
    }

    @DeleteMapping("{id}")
    void deleteWorkflow(@PathVariable("id") long id) {
        workflowController.deleteWorkflow(id);
    }
}
