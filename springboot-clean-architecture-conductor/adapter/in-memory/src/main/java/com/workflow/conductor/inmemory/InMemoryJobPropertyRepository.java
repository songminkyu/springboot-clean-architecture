package com.workflow.conductor.inmemory;

import com.workflow.conductor.domain.JobProperty;
import com.workflow.conductor.usecase.jobprop.port.JobPropertyRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryJobPropertyRepository implements JobPropertyRepository {

    private final Map<Long, JobProperty> inMemoryDb = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public List<JobProperty> findAllByWorkflowId(long workflowId) {
        return inMemoryDb.values()
                .stream()
                .filter(jp -> jp.getWorkflowId().equals(workflowId))
                .toList();
    }

    @Override
    public void save(JobProperty jobProperty) {
        long id = idGenerator.incrementAndGet();
        jobProperty.setId(id);
        inMemoryDb.put(id, jobProperty);
    }

    @Override
    public void saveAll(List<JobProperty> jobProperties) {
        jobProperties.forEach(this::save);
    }

    @Override
    public void update(JobProperty jobProperty) {
        JobProperty dbJobProperty = inMemoryDb.get(jobProperty.getId());
        if (dbJobProperty == null) {
            throw new NoSuchElementException();
        }

        inMemoryDb.put(jobProperty.getId(), jobProperty);
    }

    @Override
    public void deleteById(long id) {
        JobProperty dbJobProperty = inMemoryDb.get(id);
        if (dbJobProperty == null) {
            throw new NoSuchElementException();
        }

        inMemoryDb.remove(id);
    }

    @Override
    public void deleteByWorkflowId(long workflowId) {
        inMemoryDb.keySet()
                .forEach(id -> {
                    JobProperty jobProperty = inMemoryDb.get(id);
                    if (jobProperty.getWorkflowId() == workflowId) {
                        inMemoryDb.remove(id);
                    }
                });
    }
}
