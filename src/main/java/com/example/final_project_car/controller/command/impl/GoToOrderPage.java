package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.service.CarService;
import com.example.final_project_car.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GoToOrderPage extends Command {
    private static final long serialVersionUID = 1450934834026967708L;
    private final UserService userService = new UserService();
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;

        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        int carId = Integer.parseInt(request.getParameter("carId"));

        Car car = null;
        User user = null;

        try {
            user = userService.getUserById(userId);
            request.setAttribute("user", user);
        } catch (Exception e) {
            // add a Logger and a custom Exception + message-info page
        }
        try {
            car = carService.getCarById(carId);
            request.setAttribute("car", car);
        } catch (Exception e) {
            // add a Logger and a custom Exception + error or a message-info page
        }

        return page = PageName.CREATE_ORDER;
    }
}
