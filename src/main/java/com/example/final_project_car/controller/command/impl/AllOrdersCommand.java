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
import java.util.List;

public class AllOrdersCommand extends Command {
    private static final long serialVersionUID = 732448625769844712L;
    private static final Logger LOGGER = LogManager.getLogger(AllOrdersCommand.class);
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        List<Order> orders = null;

        try {
            orders = orderService.getAllOrders();
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get all orders");
        }

        request.setAttribute("orders", orders);

        return page = PageName.ALL_USERS_ORDERS;
    }
}
