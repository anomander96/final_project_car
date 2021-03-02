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

public class DeleteAccident extends Command {
    private static final long serialVersionUID = 7529245343011203311L;
    private static final Logger LOGGER = LogManager.getLogger(DeleteAccident.class);
    private final AccidentService accidentService = new AccidentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        int accidentId = Integer.parseInt(request.getParameter("accident_id"));

        try {
            accidentService.deleteAccident(accidentId);
            LOGGER.info("Accident with id: {} has been successfully deleted", accidentId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't delete Accident with with id: {}", accidentId);
        }
        page = PageName.ADMIN_PANEL;

        return page;
    }
}
