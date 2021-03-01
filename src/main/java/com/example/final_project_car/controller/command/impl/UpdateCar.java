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

public class UpdateCar extends Command {
    private static final long serialVersionUID = -4480641772557592046L;
    private static final Logger LOGGER = LogManager.getLogger(UpdateCar.class);
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        String idCar = (String) session.getAttribute("car_id");
        int carId = Integer.parseInt(idCar);
        Car car = null;

        try {
            car = carService.getCarById(carId);
            LOGGER.info("Car founded by id");
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get car with id: {}", carId);
        }

        if (car != null) {
            car.setCarCategoryId(Integer.parseInt(request.getParameter("car_category_id")));
            car.setBrandName(request.getParameter("brand_name"));
            car.setModelName(request.getParameter("model_name"));
            car.setColor(request.getParameter("color"));
            String price = request.getParameter("price");
            BigDecimal newPrice = new BigDecimal(price);
            car.setPrice(newPrice);
        }
        try {
            carService.updateCar(car);
            LOGGER.info("Car with id: {} successfully updated", carId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't update car with id: {}", carId);
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
