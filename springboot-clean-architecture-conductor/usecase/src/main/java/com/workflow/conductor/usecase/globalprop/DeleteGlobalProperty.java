package com.workflow.conductor.usecase.globalprop;

import com.workflow.conductor.usecase.globalprop.port.GlobalPropertyRepository;

public class DeleteGlobalProperty {

    private final GlobalPropertyRepository globalPropertyRepository;

    public DeleteGlobalProperty(GlobalPropertyRepository globalPropertyRepository) {
        this.globalPropertyRepository = globalPropertyRepository;
    }

    public void deleteGlobalProperty(long id) {
        globalPropertyRepository.deleteById(id);
    }
}
