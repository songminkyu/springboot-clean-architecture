package com.workflow.conductor.domain;

import java.util.regex.Pattern;

public class GlobalProperty {

    private final Pattern specialCharacterPattern = Pattern.compile("[^a-zA-Z0-9]");

    private Long id;

    private String name;

    private String value;

    public GlobalProperty(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public GlobalProperty(Long id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean existSpecialCharacter() {
        return specialCharacterPattern.matcher(name).find()
                || specialCharacterPattern.matcher(value).find();
    }

    public boolean existId() {
        return id != null;
    }
}
