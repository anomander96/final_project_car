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

public class ChangeOrderStatusOnPaid extends Command {
    private static final long serialVersionUID = 8255960222199277891L;
    private static final Logger LOGGER = LogManager.getLogger(ChangeOrderStatusOnPaid.class);
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        String message;
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = null;
        try {
            order = orderService.getOrderByOrderId(orderId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get order with id: {}", orderId);
        }

        if (order != null && order.getOrderStatusId() == 1) {
            message = "Wait until manager approve your order";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 2) {
            try {
                orderService.changeOrderStatusIdOnPaid(orderId);
                LOGGER.info("Order with id: {} successfully paid.", orderId);
                page = PageName.SUCCESS_PAGE;
            } catch (ServiceException e) {
                LOGGER.error("Couldn't change order status on paid.");
            }
        }

        if (order != null && order.getOrderStatusId() == 3) {
            message = "Manager declined your order, wait for a call about details.";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 4) {
            message = "You already paid. Wait for manager call about details.";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 5) {
            message = "Order has been closed. Thank You for your choice";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }
        return page;
    }
}
