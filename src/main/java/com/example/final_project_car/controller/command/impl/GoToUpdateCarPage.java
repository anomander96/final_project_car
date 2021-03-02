package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToUpdateCarPage extends Command {
    private static final long serialVersionUID = 305145008265055470L;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        String carId = request.getParameter("car_id");
        session.setAttribute("car_id", carId);

        page = PageName.UPDATE_CAR;
        return page;
    }
}
