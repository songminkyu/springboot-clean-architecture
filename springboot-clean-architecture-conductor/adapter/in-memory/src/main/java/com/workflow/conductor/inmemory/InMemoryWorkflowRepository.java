package com.workflow.conductor.inmemory;

import com.workflow.conductor.domain.Workflow;
import com.workflow.conductor.usecase.workflow.port.WorkflowRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryWorkflowRepository implements WorkflowRepository {

    private final Map<Long, Workflow> inMemoryDb = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public Optional<Workflow> findById(long workflowId) {
        return Optional.ofNullable(inMemoryDb.get(workflowId));
    }

    @Override
    public List<Workflow> findAllByProjectId(long projectId) {
        return inMemoryDb.values()
                .stream()
                .filter(workflow -> workflow.equalProject(projectId))
                .toList();
    }

    @Override
    public long save(Workflow workflow) {
        long id = idGenerator.incrementAndGet();
        inMemoryDb.put(id, workflow);
        return id;
    }

    @Override
    public long update(Workflow workflow) {
        long id = workflow.getId();
        Workflow dbWorkflow = inMemoryDb.get(id);
        if (dbWorkflow == null) {
            throw new NoSuchElementException();
        }

        inMemoryDb.put(id, workflow);
        return id;
    }

    @Override
    public void deleteById(long workflowId) {
        inMemoryDb.remove(workflowId);
    }
}
