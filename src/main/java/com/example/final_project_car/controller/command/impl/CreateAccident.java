package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.AccidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateAccident extends Command {
    private static final long serialVersionUID = 840401384508117267L;
    private static final Logger LOGGER = LogManager.getLogger(CreateAccident.class);
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
            LOGGER.info("Accident successfully created");
        } catch (ServiceException e) {
            LOGGER.error("Couldn't create accident");
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
