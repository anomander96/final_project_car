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

public class CreateCarCommand extends Command {
    private static final long serialVersionUID = -1212658804122201996L;
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();

        String carCategoryId = request.getParameter("car_category_id");
        String brandName = request.getParameter("brand_name");
        String modelName = request.getParameter("model_name");
        String color = request.getParameter("color");
        String price = request.getParameter("price");
//        long longPrice = Long.parseLong(price);
//        int realCarCategoryId = Integer.parseInt(carCategoryId);
        double realPrice = Double.parseDouble(price);

        try {
            carService.createCar(carCategoryId, brandName, modelName, color, realPrice);
        } catch (Exception e) {
            // add a logger or a message for admin or custom exception
        }
        page = PageName.ADMIN_PANEL;
        return page;
     }
}
