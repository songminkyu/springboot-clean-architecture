package com.workflow.conductor.controller;

import com.workflow.conductor.globalprop.GlobalPropertyController;
import com.workflow.conductor.globalprop.request.CreateGlobalPropertyCommand;
import com.workflow.conductor.globalprop.request.UpdateGlobalPropertyCommand;
import com.workflow.conductor.globalprop.response.GlobalPropertyResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.workflow.conductor.RequestMappingConstants.GLOBAL_PROPERTY;

@RestController
@RequestMapping(GLOBAL_PROPERTY)
public class SpringGlobalPropertyController {

    private final GlobalPropertyController globalPropertyController;

    public SpringGlobalPropertyController(GlobalPropertyController globalPropertyController) {
        this.globalPropertyController = globalPropertyController;
    }

    @GetMapping
    List<GlobalPropertyResponse> getAllProperties() {
        return globalPropertyController.getAllProperties();
    }

    @GetMapping("{id}")
    GlobalPropertyResponse getProperty(@PathVariable long id) {
        return globalPropertyController.getProperty(id);
    }

    @PostMapping
    void createProperty(@RequestBody CreateGlobalPropertyCommand command) {
        globalPropertyController.createProperty(command);
    }

    @PutMapping
    void updateProperty(@RequestBody UpdateGlobalPropertyCommand command) {
        globalPropertyController.updateProperty(command);
    }

    @DeleteMapping("{id}")
    void deleteProperty(@PathVariable long id) {
        globalPropertyController.deleteProperty(id);
    }
}
