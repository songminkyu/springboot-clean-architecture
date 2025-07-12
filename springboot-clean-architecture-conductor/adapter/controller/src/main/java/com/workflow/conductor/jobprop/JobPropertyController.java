package com.workflow.conductor.jobprop;

import com.workflow.conductor.PropertyUtil;
import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.CreateJobProperty;
import com.workflow.conductor.usecase.jobprop.DeleteJobProperty;
import com.workflow.conductor.usecase.jobprop.FindJobProperty;
import com.workflow.conductor.usecase.jobprop.UpdateJobProperty;

import java.util.List;
import java.util.Map;

public class JobPropertyController {

    private final FindJobProperty findJobProperty;
    private final CreateJobProperty createJobProperty;
    private final UpdateJobProperty updateJobProperty;
    private final DeleteJobProperty deleteJobProperty;

    public JobPropertyController(FindJobProperty findJobProperty, CreateJobProperty createJobProperty, UpdateJobProperty updateJobProperty, DeleteJobProperty deleteJobProperty) {
        this.findJobProperty = findJobProperty;
        this.createJobProperty = createJobProperty;
        this.updateJobProperty = updateJobProperty;
        this.deleteJobProperty = deleteJobProperty;
    }

    public Map<String, Object> getAllPropertiesInWorkflow(long workflowId) {
        return PropertyUtil.parseJobProperties(findJobProperty.getJobPropertiesInWorkflow(workflowId));
    }

    public void createProperties(Map<String, Object> jobProperties) {
        createJobProperty.createJobProperties(PropertyUtil.parseMapToJobProperties(jobProperties));
    }

    public void updateProperties(long workflowId, Map<String, Object> jobProperties) {
        updateJobProperty.updateProperties(workflowId, PropertyUtil.parseMapToJobProperties(jobProperties));
    }

    public void deleteProperty(long workflowId, Map<String, Object> jobProperties) {
        deleteJobProperty.deleteJobProperty(workflowId, PropertyUtil.parseMapToJobProperties(jobProperties));
    }
}
