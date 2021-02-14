package com.example.final_project_car.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

public abstract class Command implements Serializable {
    private static final long serialVersionUID = 6750055002901377101L;
    //String execute(HttpServletRequest request, HttpServletResponse response);

    public abstract String execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
    // add more exceptions about servlet

    @Override
    public final String toString() {
        return getClass().getSimpleName();
    }
}
