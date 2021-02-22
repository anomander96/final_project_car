package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeOrderStatusOnClosed extends Command {
    private static final long serialVersionUID = 6023521938989917104L;
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = null;
        try {
            order = orderService.getOrderByOrderId(orderId);
        } catch (Exception e) {
            // add a Logger or a message
        }

        if (order != null && order.getOrderStatusId() == 4) {
            try {
                orderService.changeOrderStatusIdOnClosed(orderId);
                page = PageName.ADMIN_PANEL;
            } catch (Exception e) {
                // add a Logger
            }
        }

        return page;
    }
}
