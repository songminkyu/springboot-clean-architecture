package com.workflow.conductor.usecase.globalprop;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;

public class UpdateGlobalProperty {

    private final GlobalPropertyRepository globalPropertyRepository;

    public UpdateGlobalProperty(GlobalPropertyRepository globalPropertyRepository) {
        this.globalPropertyRepository = globalPropertyRepository;
    }

    public void updateGlobalProperty(GlobalProperty globalProperty) {
        if (!globalProperty.existId()) {
            throw new IllegalArgumentException("Need to id");
        }
        globalPropertyRepository.update(globalProperty);
    }
}
