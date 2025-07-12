package com.workflow.conductor.domain;

import java.util.regex.Pattern;

public class Project {

    private final Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

    private Long id;

    private String name;

    private String description;

    public Project(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean existSpecialCharacter() {
        return specialCharacterPattern.matcher(name).find();
    }

    public boolean existId() {
        return id != null;
    }
}
