package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.service.OrderService;

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
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("user_id");

        int carId = Integer.parseInt(request.getParameter("carId"));
        int rentHours = Integer.parseInt(request.getParameter("rentHours"));
//        String time = request.getParameter("rentDuration");
//        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//        long ms = 0;
//        try {
//            ms = formatter.parse(time).getTime();
//        } catch (Exception e) {
//            // add a Logger and a custom exception
//        }
//        Time rentDuration = new Time(ms);
        boolean withDriver = false;
        try {
            orderService.createOrderByUser(userId, carId, withDriver, rentHours);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }

        List<Order> orders = null;

        try {
            orders = orderService.getOrdersByUserId(userId);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }

        request.setAttribute("orders", orders);
        return page = PageName.USER_ORDERS;
    }
}
