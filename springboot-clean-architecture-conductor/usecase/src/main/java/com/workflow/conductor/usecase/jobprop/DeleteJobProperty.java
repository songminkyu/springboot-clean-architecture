package com.workflow.conductor.usecase.jobprop;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;

public class DeleteJobProperty {

    private final JobPropertyRepository jobPropertyRepository;

    public DeleteJobProperty(JobPropertyRepository jobPropertyRepository) {
        this.jobPropertyRepository = jobPropertyRepository;
    }

    public void deleteJobProperty(long workflowId, List<JobProperty> jobProperties) {
        deleteJobProperty(workflowId, jobProperties);
    }
}
