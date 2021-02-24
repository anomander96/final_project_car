package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteAccident extends Command {
    private static final long serialVersionUID = 7529245343011203311L;
    private final AccidentService accidentService = new AccidentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        int accidentId = Integer.parseInt(request.getParameter("accident_id"));

        try {
            accidentService.deleteAccident(accidentId);
        } catch (Exception e) {
            // add a Logger and a error-info message
        }
        page = PageName.ADMIN_PANEL;

        return page;
    }
}
