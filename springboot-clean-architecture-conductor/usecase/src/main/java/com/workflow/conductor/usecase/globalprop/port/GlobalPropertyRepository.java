package com.workflow.conductor.usecase.globalprop.port;

import com.workflow.conductor.domain.GlobalProperty;

import java.util.List;
import java.util.Optional;

public interface GlobalPropertyRepository {

    Optional<GlobalProperty> findById(long id);

    List<GlobalProperty> findAll();

    void save(GlobalProperty globalProperty);

    void update(GlobalProperty globalProperty);

    void deleteById(long id);

    void deleteAll();
}
