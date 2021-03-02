package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class OrdersUserList extends Command {
    private static final long serialVersionUID = 1729304145778520834L;
    private static final Logger LOGGER = LogManager.getLogger(OrdersUserList.class);
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");

        int carId = Integer.parseInt(request.getParameter("carId"));
        int rentHours = Integer.parseInt(request.getParameter("rentHours"));
        boolean withDriver = false;
        try {
            orderService.createOrderByUser(userId, carId, withDriver, rentHours);
            LOGGER.info("New Order successfully created");
        } catch (ServiceException e) {
            LOGGER.error("Couldn't create a new Order");
        }

        List<Order> orders = null;

        try {
            orders = orderService.getOrdersByUserId(userId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't find Order with user id: {}", userId);
        }

        request.setAttribute("orders", orders);
        return page = PageName.USER_ORDERS;
    }
}
