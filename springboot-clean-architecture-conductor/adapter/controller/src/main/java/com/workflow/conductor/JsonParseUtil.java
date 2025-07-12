package com.workflow.conductor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workflow.conductor.domain.ConductorTask;

import java.util.List;

public class JsonParseUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonParseUtil() {
    }

    public static List<ConductorTask> parseTasks(String jsonDefinition) {
        try {
            return objectMapper.readValue(jsonDefinition, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String parseStringJsonDefList(List<ConductorTask> tasks) {
        try {
            return objectMapper.writeValueAsString(tasks);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String parseStringJsonDef(ConductorTask tasks) {
        try {
            return objectMapper.writeValueAsString(tasks);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
