package com.workflow.conductor.usecase.jobprop;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;

public class FindJobProperty {

    private final JobPropertyRepository jobPropertyRepository;

    public FindJobProperty(JobPropertyRepository jobPropertyRepository) {
        this.jobPropertyRepository = jobPropertyRepository;
    }

    public List<JobProperty> getJobPropertiesInWorkflow(long workflowId) {
        return jobPropertyRepository.findAllByWorkflowId(workflowId);
    }
}
