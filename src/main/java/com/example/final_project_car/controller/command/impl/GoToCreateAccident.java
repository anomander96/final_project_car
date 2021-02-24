package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToCreateAccident extends Command {
    private static final long serialVersionUID = -78779007478220790L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return PageName.CREATE_ACCIDENT;
    }
}
