package com.workflow.conductor.domain;

public enum NodeType {

    /**
     * Operator Tasks
     */
    DO_WHILE("do-while-task","DO_WHILE"),
    FORK("fork-task", "FORK_JOIN"),
    JOIN("join-task", "JOIN"),
    SET_VARIABLE("set-variable-task","SET_VARIABLE"),
    SWITCH("switch-task","SWITCH"),
    TERMINATE("terminate-task", "TERMINATE"),
    NOOP("no-op-task","NOOP"),

    /**
     * System Tasks
     */
    HTTP("http-task", "HTTP"),
    INLINE("inline-task","INLINE"),
    JSON_JQ_TRANSFORM("json-jq-transform-task", "JSON_JQ_TRANSFORM"),
    KAFKA_PUBLISH("kafka-publish-task", "KAFKA_PUBLISH"),
    WAIT("wait-task", "WAIT");

    private final String name;
    private final String type;

    NodeType(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public static String getName(NodeType nodeType) {
        return nodeType.name;
    }

    public static String getType(NodeType nodeType) {
        return nodeType.type;
    }
}
