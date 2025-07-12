package com.workflow.conductor.usecase.globalprop;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;

public class CreateGlobalProperty {

    private final GlobalPropertyRepository globalPropertyRepository;

    public CreateGlobalProperty(GlobalPropertyRepository globalPropertyRepository) {
        this.globalPropertyRepository = globalPropertyRepository;
    }

    public void createGlobalProperty(GlobalProperty globalProperty) {
        if (globalProperty.existSpecialCharacter()) {
            throw new IllegalArgumentException("Name cannot contain special characters.");
        }

        globalPropertyRepository.save(globalProperty);
    }
}
