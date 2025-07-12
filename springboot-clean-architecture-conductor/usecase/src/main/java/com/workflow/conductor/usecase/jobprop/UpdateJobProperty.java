package com.workflow.conductor.usecase.jobprop;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;

public class UpdateJobProperty {

    private final JobPropertyRepository jobPropertyRepository;

    public UpdateJobProperty(JobPropertyRepository jobPropertyRepository) {
        this.jobPropertyRepository = jobPropertyRepository;
    }

    public void updateProperties(long workflowId, List<JobProperty> jobProperties) {
        jobPropertyRepository.deleteByWorkflowId(workflowId);
        jobPropertyRepository.saveAll(jobProperties);
    }
}
