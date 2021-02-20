package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CreateOrderCommand extends Command {
    private static final long serialVersionUID = -4122067013181622174L;
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");
        int carId = Integer.parseInt(request.getParameter("carId"));
        int rentDuration = Integer.parseInt(request.getParameter("rentDuration"));
//
        // add a Logger and a custom exception or message
        if (request.getParameter("withDriver").equals("true")) {
            try {
                orderService.createOrderByUser(userId, carId, true, rentDuration);
            } catch (Exception e) {
                // add a Logger and a custom exception or forward to the error message page
            }
        } else {
            try {
                orderService.createOrderByUser(userId, carId, false, rentDuration);
            } catch (Exception e) {
                // add a Logger and a custom exception or forward to the error message page
            }
        }



        List<Order> orders = null;
        try {
            orders = orderService.getOrdersByUserId(userId);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }

        request.setAttribute("orders", orders);
        page = PageName.USER_ORDERS;
        return page;
    }
}
