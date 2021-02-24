package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

public class UpdateCar extends Command {
    private static final long serialVersionUID = -4480641772557592046L;
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
//        int carId = Integer.parseInt((String) request.getAttribute("car_id"));
        int carId = Integer.parseInt(request.getParameter("car_id"));
        Car car = null;

        try {
            car = carService.getCarById(carId);
        } catch (Exception e) {
            // add a Logger and an error-info page
        }

        if (car != null) {
            car.setCarCategoryId(Integer.parseInt(request.getParameter("car_category_id")));
            car.setBrandName(request.getParameter("brand_name"));
            car.setModelName(request.getParameter("model_name"));
            car.setColor(request.getParameter("color"));
            String price = request.getParameter("price");
            BigDecimal newPrice = new BigDecimal(price);
            car.setPrice(newPrice);
//            car.setCarCategoryId(3);
//            car.setBrandName("BMW");
//            car.setModelName("X6");
//            car.setColor("red");
//            String price = request.getParameter("price");
//            BigDecimal newPrice = new BigDecimal(66);
//            car.setPrice(newPrice);
        }
        try {
            carService.updateCar(car);
        } catch (Exception e) {
            // add a Logger and a custom exception
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
