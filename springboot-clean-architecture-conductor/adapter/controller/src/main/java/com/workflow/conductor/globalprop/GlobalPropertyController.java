package com.workflow.conductor.globalprop;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.globalprop.request.CreateGlobalPropertyCommand;
import com.workflow.conductor.globalprop.request.UpdateGlobalPropertyCommand;
import com.workflow.conductor.globalprop.response.GlobalPropertyResponse;
import com.workflow.conductor.usecase.globalprop.CreateGlobalProperty;
import com.workflow.conductor.usecase.globalprop.DeleteGlobalProperty;
import com.workflow.conductor.usecase.globalprop.FindGlobalProperty;
import com.workflow.conductor.usecase.globalprop.UpdateGlobalProperty;

import java.util.List;

public class GlobalPropertyController {

    private final FindGlobalProperty findGlobalProperty;
    private final CreateGlobalProperty createGlobalProperty;
    private final UpdateGlobalProperty updateGlobalProperty;
    private final DeleteGlobalProperty deleteGlobalProperty;

    public GlobalPropertyController(FindGlobalProperty findGlobalProperty, CreateGlobalProperty createGlobalProperty, UpdateGlobalProperty updateGlobalProperty, DeleteGlobalProperty deleteGlobalProperty) {
        this.findGlobalProperty = findGlobalProperty;
        this.createGlobalProperty = createGlobalProperty;
        this.updateGlobalProperty = updateGlobalProperty;
        this.deleteGlobalProperty = deleteGlobalProperty;
    }

    public List<GlobalPropertyResponse> getAllProperties() {
        List<GlobalProperty> globalProperties = findGlobalProperty.getAllGlobalProperties();
        return globalProperties.stream()
                .map(GlobalPropertyResponse::from)
                .toList();
    }

    public GlobalPropertyResponse getProperty(long id) {
        GlobalProperty globalProperty = findGlobalProperty.getGlobalProperty(id);
        return GlobalPropertyResponse.from(globalProperty);
    }

    public void createProperty(CreateGlobalPropertyCommand command) {
        GlobalProperty globalProperty = command.toDomain();
        createGlobalProperty.createGlobalProperty(globalProperty);
    }

    public void updateProperty(UpdateGlobalPropertyCommand command) {
        GlobalProperty globalProperty = command.toDomain();
        updateGlobalProperty.updateGlobalProperty(globalProperty);
    }

    public void deleteProperty(long id) {
        deleteGlobalProperty.deleteGlobalProperty(id);
    }
}
