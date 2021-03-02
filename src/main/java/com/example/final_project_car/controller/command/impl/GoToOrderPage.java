package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.CarService;
import com.example.final_project_car.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToOrderPage extends Command {
    private static final long serialVersionUID = 1450934834026967708L;
    private static final Logger LOGGER = LogManager.getLogger(GoToOrderPage.class);
    private final UserService userService = new UserService();
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        int carId = Integer.parseInt(request.getParameter("carId"));

        Car car;
        User user;

        try {
            user = userService.getUserById(userId);
            request.setAttribute("user", user);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't find user with id: {}", userId);
        }
        try {
            car = carService.getCarById(carId);
            request.setAttribute("car", car);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't find car with car with id: {}", carId);
        }

        return page = PageName.CREATE_ORDER;
    }
}
