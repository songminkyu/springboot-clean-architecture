package com.workflow.conductor.usecase.jobprop;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;

public class CreateJobProperty {

    private final JobPropertyRepository jobPropertyRepository;

    public CreateJobProperty(JobPropertyRepository jobPropertyRepository) {
        this.jobPropertyRepository = jobPropertyRepository;
    }

    public void createJobProperties(List<JobProperty> jobProperties) {
        jobPropertyRepository.saveAll(jobProperties);
    }
}
