package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteCar extends Command {
    private static final long serialVersionUID = 2291318538204361680L;
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        int carId = Integer.parseInt(request.getParameter("car_id"));

        try {
            carService.deleteCar(carId);
        } catch (Exception e) {
            // add a Logger and an error-info page
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
