package com.workflow.conductor.inmemory;

import com.workflow.conductor.domain.Project;
import com.workflow.conductor.usecase.project.port.ProjectRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryProjectRepository implements ProjectRepository {

    private final Map<Long, Project> inMemoryDb = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public Optional<Project> findById(long id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    @Override
    public List<Project> findAll() {
        return inMemoryDb.values()
                .stream()
                .toList();
    }

    @Override
    public long save(Project project) {
        long id = idGenerator.incrementAndGet();
        project.setId(id);
        inMemoryDb.put(id, project);
        return id;
    }

    @Override
    public long update(Project project) {
        Long id = project.getId();
        Project dbProject = inMemoryDb.get(id);
        if (dbProject == null) {
            throw new NoSuchElementException();
        }
        inMemoryDb.put(id, project);
        return id;
    }

    @Override
    public void deleteById(long id) {
        inMemoryDb.remove(id);
    }
}
