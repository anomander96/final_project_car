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

public class AllOrdersCommand extends Command {
    private static final long serialVersionUID = 732448625769844712L;
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        List<Order> orders = null;

        try {
            orders = orderService.getAllOrders();
        } catch (Exception e) {
            // add a Logger and a custom exception or message for user
        }

        request.setAttribute("orders", orders);

        return page = PageName.ALL_USERS_ORDERS;
    }
}
