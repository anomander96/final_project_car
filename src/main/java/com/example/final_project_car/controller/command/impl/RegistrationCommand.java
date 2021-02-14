package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationCommand extends Command {
    private static final long serialVersionUID = 8458030426649305346L;
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = PageName.SIGN_UP_PAGE;
        User user = null;

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String passport = request.getParameter("passport");

        try {
            userService.createUser(firstName, lastName, login, password, email, phone, passport);
        } catch (Exception e) {
            // add a logger and a UserServiceException
            page = PageName.ERROR_USER_PAGE;
            return page;
        }

        try {
            user = userService.getUserByLogin(login);
        } catch (Exception e) {
            // add a logger and a custom exception;
        }

        if (user != null) {
            HttpSession httpSession = request.getSession();
            int id = user.getUserId();
            page = PageName.MENU_LIST_PAGE;
        }
        return page;
    }
}
