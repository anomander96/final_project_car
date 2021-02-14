package com.example.final_project_car.controller.command;

public enum JspParameterType {
    COMMAND,
    HREF,
    LANGUAGE;

    public String getName() {
        return name().toLowerCase();
    }
}
