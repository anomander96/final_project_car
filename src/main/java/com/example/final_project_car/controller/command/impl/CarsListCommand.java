package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CarsListCommand extends Command {
    private static final long serialVersionUID = -7095101596672606605L;
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession httpSession = request.getSession();
        List<Car> cars = null;

        try {
            cars = carService.getAllCars();
        } catch (Exception e) {
            // add a logger and or an inform message with custom exception
        }

        request.setAttribute("cars", cars);
        page = PageName.CARS_LIST_PAGE;
        return page;
    }
}
