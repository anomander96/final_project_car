package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand extends Command {
    private static final long serialVersionUID = 4253433988635672850L;
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return PageName.MAIN_PAGE;
    }
}
