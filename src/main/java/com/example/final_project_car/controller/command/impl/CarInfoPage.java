package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CarInfoPage extends Command {
    private static final long serialVersionUID = 6312881918344120595L;
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
        } catch (Exception e) {
            // add a logger and a some info page, like error page with some text
        }
        return page = PageName.CAR_INFO;
    }
}
