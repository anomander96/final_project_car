package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.AccidentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowAccidentCommand extends Command {
    private static final long serialVersionUID = -1126423170856528993L;
    private static final Logger LOGGER = LogManager.getLogger(ShowAccidentCommand.class);
    private final AccidentService accidentService = new AccidentService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        List<Accident> accidents = null;

        try {
            accidents = accidentService.getUserAccidentsByOrder(orderId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't find accidents with order id: {}", orderId);
        }

        request.setAttribute("accidents", accidents);
        page = PageName.USER_ACCIDENTS_BY_ORDER_ID;

        return page;
    }
}
