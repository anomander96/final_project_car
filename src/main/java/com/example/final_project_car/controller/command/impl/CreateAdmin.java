package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateAdmin extends Command {
    private static final long serialVersionUID = 482119848555293937L;
    private static final Logger LOGGER = LogManager.getLogger(CreateAdmin.class);
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");

        try {
            userService.createAdmin(firstName, lastName, login, password, email, phone, passport);
            LOGGER.info("New Administrator successfully created");
            page = PageName.ADMIN_PANEL;
        } catch (Exception e) {
            LOGGER.error("Couldn't create new Administrator");
        }

        return page;
    }
}
