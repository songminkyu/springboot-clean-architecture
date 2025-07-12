package com.workflow.conductor;

import com.workflow.conductor.domain.GlobalProperty;
import com.workflow.conductor.domain.JobProperty;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class PropertyUtil {

    private PropertyUtil() {
    }

    public static Map<String, Object> parseProperties(
            List<JobProperty> jobProperties,
            List<GlobalProperty> globalProperties) {
        Map<String, Object> jobPropertiesMap = jobProperties.stream()
                .collect(Collectors.toMap(
                        JobProperty::getName, JobProperty::getValue,
                        (a, b) -> b, ConcurrentHashMap::new));
        Map<String, Object> globalPropertiesMap = globalProperties.stream()
                .collect(Collectors.toMap(
                        GlobalProperty::getName, GlobalProperty::getValue,
                        (a, b) -> b, ConcurrentHashMap::new));

        Map<String, Object> combinedProperties = new ConcurrentHashMap<>(jobPropertiesMap);
        combinedProperties.putAll(globalPropertiesMap);

        return combinedProperties;
    }

    public static Map<String, Object> parseJobProperty(JobProperty jobProperty) {
        Map<String, Object> result = new ConcurrentHashMap<>();
        result.put(jobProperty.getName(), jobProperty.getValue());
        return result;
    }

    public static Map<String, Object> parseJobProperties(List<JobProperty> jobProperties) {
        return jobProperties.stream()
                .collect(
                        Collectors.toMap(
                                JobProperty::getName, JobProperty::getValue,
                                (a, b) -> b,
                                ConcurrentHashMap::new)
                );
    }

    public static List<JobProperty> parseMapToJobProperties(Map<String, Object> jobProperties) {
        return jobProperties.keySet()
                .stream()
                .map(key -> new JobProperty(key, String.valueOf(jobProperties.get(key))))
                .toList();
    }
}
