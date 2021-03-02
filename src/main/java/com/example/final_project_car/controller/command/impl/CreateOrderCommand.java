package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.CarService;
import com.example.final_project_car.service.OrderService;
import com.example.final_project_car.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CreateOrderCommand extends Command {
    private static final long serialVersionUID = -4122067013181622174L;
    private static final Logger LOGGER = LogManager.getLogger(CreateOrderCommand.class);
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        int carId = Integer.parseInt(request.getParameter("carId"));
        int rentDuration = Integer.parseInt(request.getParameter("rentDuration"));

        if (request.getParameter("withDriver").equals("true")) {
            try {
                orderService.createOrderByUser(userId, carId, true, rentDuration);
                LOGGER.info("New Order successfully created");
            } catch (ServiceException e) {
                LOGGER.error("Couldn't create a new Order");
            }
        } else {
            try {
                orderService.createOrderByUser(userId, carId, false, rentDuration);
                LOGGER.info("New Order successfully created");
            } catch (ServiceException e) {
                LOGGER.error("Couldn't create a new Order");
            }
        }

        List<Order> orders = null;
        try {
            orders = orderService.getOrdersByUserId(userId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't find Order with user id: {}", userId);
        }

        request.setAttribute("orders", orders);
        page = PageName.USER_ORDERS;
        return page;
    }
}
