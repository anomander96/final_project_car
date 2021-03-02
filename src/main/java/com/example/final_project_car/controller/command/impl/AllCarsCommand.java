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
import java.util.List;

public class AllCarsCommand extends Command {
    private static final long serialVersionUID = 7811412590747690448L;
    private static final Logger LOGGER = LogManager.getLogger(AllCarsCommand.class);
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        List<Car> cars = null;

        try {
            cars = carService.getAllCars();
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get all cars");
        }

        request.setAttribute("cars", cars);
        page = PageName.ALL_CARS;
        return page;
    }
}
