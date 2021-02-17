package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompleteOrder extends Command {
    private static final long serialVersionUID = -2877078940561392037L;
    private final OrderService orderService = new OrderService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return null;
    }
}
