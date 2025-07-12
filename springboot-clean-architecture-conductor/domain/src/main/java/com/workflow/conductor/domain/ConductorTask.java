package com.workflow.conductor.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConductorTask {
    private final String name;
    private final NodeType nodeType;
    private final String description;
    private final Map<String, Object> taskInputParams;
    private final Map<String, List<ConductorTask>> decisionCases;
    private final List<ConductorTask> defaultCase;
    private final List<List<ConductorTask>> forkTasks;
    private final List<String> joinOn;
    private final boolean optional;
    private final String evaluatorType;
    private final String expression;
    private final String loopCondition;
    private final String loopOver;
    private final String sink;
    private final boolean asyncComplete;

//    public ConductorTask() {
//        this.name = "";
//        this.nodeType = null;
//        this.description = "";
//        this.taskInputParams = new ConcurrentHashMap<>();
//        this.decisionCases = new ConcurrentHashMap<>();
//        this.defaultCase = new ArrayList<>();
//        this.forkTasks = new ArrayList<>();
//        this.joinOn = new ArrayList<>();
//        this.optional = false;
//        this.evaluatorType = "";
//        this.expression = "";
//        this.loopCondition = "";
//        this.loopOver = "";
//        this.sink = "";
//        this.asyncComplete = false;
//    }

    public ConductorTask(
            String name,
            NodeType nodeType,
            String description,
            Map<String, Object> taskInputParams,
            Map<String, List<ConductorTask>> decisionCases,
            List<ConductorTask> defaultCase,
            List<List<ConductorTask>> forkTasks,
            List<String> joinOn,
            boolean optional,
            String evaluatorType,
            String expression,
            String loopCondition,
            String loopOver,
            String sink,
            boolean asyncComplete) {
        this.name = name;
        this.nodeType = nodeType;
        this.description = description;
        this.taskInputParams = taskInputParams;
        this.decisionCases = decisionCases;
        this.defaultCase = defaultCase;
        this.forkTasks = forkTasks;
        this.joinOn = joinOn;
        this.optional = optional;
        this.evaluatorType = evaluatorType;
        this.expression = expression;
        this.loopCondition = loopCondition;
        this.loopOver = loopOver;
        this.sink = sink;
        this.asyncComplete = asyncComplete;
    }

    public String getName() {
        return name;
    }

    public NodeType getNodeType() {
        return nodeType;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Object> getTaskInputParams() {
        return taskInputParams;
    }

    public Map<String, List<ConductorTask>> getDecisionCases() {
        return decisionCases;
    }

    public List<ConductorTask> getDefaultCase() {
        return defaultCase;
    }

    public List<List<ConductorTask>> getForkTasks() {
        return forkTasks;
    }

    public List<String> getJoinOn() {
        return joinOn;
    }

    public boolean isOptional() {
        return optional;
    }

    public String getEvaluatorType() {
        return evaluatorType;
    }

    public String getExpression() {
        return expression;
    }

    public String getLoopCondition() {
        return loopCondition;
    }

    public String getLoopOver() {
        return loopOver;
    }

    public String getSink() {
        return sink;
    }

    public boolean isAsyncComplete() {
        return asyncComplete;
    }

    @Override
    public String toString() {
        return "ConductorTask{" +
                "name='" + name + '\'' +
                ", nodeType=" + nodeType +
                ", description='" + description + '\'' +
                ", taskInputParams=" + taskInputParams +
                ", decisionCases=" + decisionCases +
                ", defaultCase=" + defaultCase +
                ", forkTasks=" + forkTasks +
                ", joinOn=" + joinOn +
                ", optional=" + optional +
                ", loopCondition='" + loopCondition + '\'' +
                ", loopOver='" + loopOver + '\'' +
                '}';
    }
}
