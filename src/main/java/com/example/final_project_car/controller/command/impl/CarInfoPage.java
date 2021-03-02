package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CarInfoPage extends Command {
    private static final long serialVersionUID = 6312881918344120595L;
    private static final Logger LOGGER = LogManager.getLogger(CarInfoPage.class);
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        String carId = request.getParameter("carId");

        try {
            Car car;
            car = carService.getCarById(Integer.parseInt(carId));
            request.setAttribute("car", car);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get car with id: {}", carId);
        }
        return page = PageName.CAR_INFO;
    }
}
