package com.workflow.conductor.inmemory;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryGlobalPropertyRepository implements GlobalPropertyRepository {

    private final Map<Long, GlobalProperty> inMemoryDb = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public Optional<GlobalProperty> findById(long id) {
        return Optional.ofNullable(inMemoryDb.get(id));
    }

    @Override
    public List<GlobalProperty> findAll() {
        return inMemoryDb.values()
                .stream()
                .toList();
    }

    @Override
    public void save(GlobalProperty globalProperty) {
        long id = idGenerator.incrementAndGet();
        globalProperty.setId(id);
        inMemoryDb.put(id, globalProperty);
    }

    @Override
    public void update(GlobalProperty globalProperty) {
        GlobalProperty dbGlobalProperty = inMemoryDb.get(globalProperty.getId());
        if (dbGlobalProperty == null) {
            throw new NoSuchElementException();
        }

        inMemoryDb.put(globalProperty.getId(), globalProperty);
    }

    @Override
    public void deleteById(long id) {
        inMemoryDb.remove(id);
    }

    @Override
    public void deleteAll() {
        inMemoryDb.keySet()
                .forEach(inMemoryDb::remove);
    }
}
