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

public class GoToUserOrdersPage extends Command {
    private static final long serialVersionUID = 3643769355111177672L;
    private final OrderService orderService = new OrderService();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id") ;

        List<Order> orders = null;

        try {
            orders = orderService.getOrdersByUserId(userId);
            request.setAttribute("orders", orders);
        } catch (Exception e) {
            // add a Logger and a custom exception
        }
//        request.setAttribute("orders", orders);
        return PageName.USER_ORDERS;
    }
}
