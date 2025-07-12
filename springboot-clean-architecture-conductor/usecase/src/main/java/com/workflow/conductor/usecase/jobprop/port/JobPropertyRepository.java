package com.workflow.conductor.usecase.jobprop.port;

import com.workflow.conductor.domain.JobProperty;

import java.util.List;

public interface JobPropertyRepository {
    List<JobProperty> findAllByWorkflowId(long workflowId);

    void save(JobProperty jobProperty);

    void saveAll(List<JobProperty> jobProperties);

    void update(JobProperty jobProperty);

    void deleteById(long id);

    void deleteByWorkflowId(long workflowId);
}
