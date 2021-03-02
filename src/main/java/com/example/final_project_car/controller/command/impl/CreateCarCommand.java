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
import java.math.BigDecimal;

public class CreateCarCommand extends Command {
    private static final long serialVersionUID = -1212658804122201996L;
    private static final Logger LOGGER = LogManager.getLogger(CreateCarCommand.class);
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
        double realPrice = Double.parseDouble(price);

        try {
            carService.createCar(carCategoryId, brandName, modelName, color, realPrice);
            LOGGER.info("New car successfully added");
        } catch (ServiceException e) {
            LOGGER.error("Couldn't add a new car");
        }
        page = PageName.ADMIN_PANEL;
        return page;
     }
}
