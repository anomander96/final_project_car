package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToCreateCarPage extends Command {
    private static final long serialVersionUID = 3546647072378985051L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        return page = PageName.CREATE_CAR;
    }
}
