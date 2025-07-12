package com.workflow.conductor.workflow;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.jobprop.FindJobProperty;
import com.workflow.conductor.usecase.workflow.CreateWorkflow;
import com.workflow.conductor.usecase.workflow.DeleteWorkflow;
import com.workflow.conductor.usecase.workflow.FindWorkflow;
import com.workflow.conductor.usecase.workflow.UpdateWorkflow;
import com.workflow.conductor.workflow.request.CreateWorkflowCommand;
import com.workflow.conductor.workflow.request.UpdateWorkflowCommand;
import com.workflow.conductor.workflow.response.WorkflowResponse;

import java.util.List;

public class WorkflowController {

    private final FindWorkflow findWorkflow;
    private final FindJobProperty findJobProperty;
    private final CreateWorkflow createWorkflow;
    private final UpdateWorkflow updateWorkflow;
    private final DeleteWorkflow deleteWorkflow;

    public WorkflowController(FindWorkflow findWorkflow, FindJobProperty findJobProperty, CreateWorkflow createWorkflow, UpdateWorkflow updateWorkflow, DeleteWorkflow deleteWorkflow) {
        this.findWorkflow = findWorkflow;
        this.findJobProperty = findJobProperty;
        this.createWorkflow = createWorkflow;
        this.updateWorkflow = updateWorkflow;
        this.deleteWorkflow = deleteWorkflow;
    }

    public WorkflowResponse getWorkflow(long workflowId) {
        Workflow workflow = findWorkflow.getWorkflow(workflowId);
        List<JobProperty> jobProperties = findJobProperty.getJobPropertiesInWorkflow(workflowId);
        return WorkflowResponse.from(workflow, jobProperties);
    }

    public List<WorkflowResponse> getWorkflowInProject(long projectId) {
        List<Workflow> workflows = findWorkflow.getWorkflowsInProject(projectId);
        return workflows.stream()
                .map(workflow -> {
                    List<JobProperty> jobPropertiesInWorkflow = findJobProperty.getJobPropertiesInWorkflow(workflow.getId());
                    return WorkflowResponse.from(workflow, jobPropertiesInWorkflow);
                }).toList();
    }

    public long createWorkflow(CreateWorkflowCommand command) {
        return createWorkflow.createWorkflow(command.toDomain());
    }

    public long updateWorkflow(UpdateWorkflowCommand command) {
        return updateWorkflow.updateWorkflow(command.toDomain());
    }

    public void deleteWorkflow(long id) {
        deleteWorkflow.deleteWorkflow(id);
    }
}
