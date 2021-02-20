package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToHomePage extends Command {
    private static final long serialVersionUID = -1382558009044672703L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        page = PageName.MENU_LIST_PAGE;
        return page;
    }
}
