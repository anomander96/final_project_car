package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AllAccidentsCommand extends Command {
    private static final long serialVersionUID = -3216529046045943305L;
    private final AccidentService accidentService = new AccidentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        List<Accident> accidents = null;

        try {
            accidents = accidentService.getAllAccidents();
        } catch (Exception e) {
            // add a Logger and an info page with custom exception
        }

        request.setAttribute("accidents", accidents);
        page = PageName.ALL_ACCIDENTS;
        return page;
    }
}
