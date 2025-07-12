package com.workflow.conductor.usecase.globalprop;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class FindGlobalProperty {

    private final GlobalPropertyRepository globalPropertyRepository;

    public FindGlobalProperty(GlobalPropertyRepository globalPropertyRepository) {
        this.globalPropertyRepository = globalPropertyRepository;
    }

    public GlobalProperty getGlobalProperty(long id) {
        return globalPropertyRepository.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<GlobalProperty> getAllGlobalProperties() {
        return globalPropertyRepository.findAll();
    }
}
