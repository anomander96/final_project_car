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

public class ChangeOrderStatusOnClosed extends Command {
    private static final long serialVersionUID = 6023521938989917104L;
    private static final Logger LOGGER = LogManager.getLogger(ChangeOrderStatusOnClosed.class);
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        String message;
        HttpSession session = request.getSession();

        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = null;
        try {
            order = orderService.getOrderByOrderId(orderId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get order with id: {}", orderId);
        }

        if (order != null && order.getOrderStatusId() == 1) {
            message = "Order status is Pending. Firstly you need approve order or decline";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 2) {
            message = "Order is Approved, but not paid. Wait until client make a purchase";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 3) {
            message = "Order is Declined. Close operation is restricted";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 4) {
            try {
                orderService.changeOrderStatusIdOnClosed(orderId);
                LOGGER.info("Order status with id: {} successfully changed on Closed", orderId);
                page = PageName.ADMIN_PANEL;
            } catch (ServiceException e) {
                LOGGER.error("Couldn't change order status with id: {} on Closed", orderId);
            }
        }

        if (order != null && order.getOrderStatusId() == 5) {
            message = "Order is already closed";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        return page;
    }
}
