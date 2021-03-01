package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteCar extends Command {
    private static final long serialVersionUID = 2291318538204361680L;
    private static final Logger LOGGER = LogManager.getLogger(DeleteCar.class);
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        int carId = Integer.parseInt(request.getParameter("car_id"));

        try {
            carService.deleteCar(carId);
            LOGGER.info("Car with id: {} successfully deleted", carId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't delete car with id: {}", carId);
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
