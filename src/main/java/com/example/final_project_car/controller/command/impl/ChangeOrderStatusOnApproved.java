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

public class ChangeOrderStatusOnApproved extends Command {
    private static final long serialVersionUID = -3335158121702420966L;
    private static final Logger LOGGER = LogManager.getLogger(ChangeOrderStatusOnApproved.class);
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
            LOGGER.error("Couldn't find order with id: {}", orderId);
        }


        if (order != null && order.getOrderStatusId() == 1) {
            try {
                orderService.changeOrderStatusIdOnApproved(orderId);
                LOGGER.info("Order status with order id: {} has been changed on Approved", orderId);
                page = PageName.ADMIN_PANEL;
            } catch (ServiceException e) {
                LOGGER.error("Couldn't change order status with order id: {} on Approved", orderId);
            }
        }

        if (order != null && order.getOrderStatusId() == 2) {
            message = "You already approved this order";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 3) {
            message = "You already declined this order. Approve operation is restricted";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 4) {
            message = "Client already paid. Approve operation is restricted";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }

        if (order != null && order.getOrderStatusId() == 5) {
            message = "Order has been closed. Approve operation is restricted";
            request.setAttribute("message", message);
            page = PageName.INFO_PAGE;
        }
        return page;
    }
}
