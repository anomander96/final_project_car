package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.service.AccidentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateAccident extends Command {
    private static final long serialVersionUID = 840401384508117267L;
    private final AccidentService accidentService = new AccidentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        int accidentCategoryId = Integer.parseInt(request.getParameter("accident_category_id"));
        int orderId = Integer.parseInt(request.getParameter("order_id"));
        String description = request.getParameter("description");
        String costPerDamage = request.getParameter("cost_per_damage");

        try {
            accidentService.createAccidentByAdmin(accidentCategoryId, orderId, description, costPerDamage);
        } catch (Exception e) {
            // add a logger and a custom Exception and error page;
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
