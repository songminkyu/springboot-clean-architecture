package com.workflow.conductor.controller;

import com.workflow.conductor.jobprop.JobPropertyController;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.workflow.conductor.RequestMappingConstants.JOB_PROPERTY;

@RestController
@RequestMapping(JOB_PROPERTY)
public class SpringJobPropertyController {

    private final JobPropertyController jobPropertyController;

    public SpringJobPropertyController(JobPropertyController jobPropertyController) {
        this.jobPropertyController = jobPropertyController;
    }

    @GetMapping("{id}")
    Map<String, Object> getAllPropertiesInWorkflow(@PathVariable("id") long workflowId) {
        return jobPropertyController.getAllPropertiesInWorkflow(workflowId);
    }

    @PostMapping
    void createProperties(@RequestBody Map<String, Object> jobProperties) {
        jobPropertyController.createProperties(jobProperties);
    }

    @PutMapping("{id}")
    void updateProperties(@PathVariable("id") long workflowId, @RequestBody Map<String, Object> jobProperties) {
        jobPropertyController.updateProperties(workflowId, jobProperties);
    }

    @DeleteMapping("{id}")
    void deleteProperty(@PathVariable("id") long workflowId, @RequestBody Map<String, Object> jobProperties) {
        jobPropertyController.deleteProperty(workflowId, jobProperties);
    }
}
