package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends Command {

    private static final long serialVersionUID = 7578654847871496658L;
    // add a Logger here
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // add more exception to the method signature
        //HttpSession session = request.getSession();
        String page = PageName.LOGIN_PAGE;
        String login = request.getParameter("login");
        // add a Logger
        String password = request.getParameter("password");


        // add an error handler or validator(better a validator)

        User user = null;

        try {
            user = userService.signIn(login, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (user != null) {
            HttpSession session = request.getSession();
            user = userService.getUserByLogin(login);
            session.setAttribute("user", user);
            page = PageName.MENU_LIST_PAGE;
        }
//        else if (user == null){
//            //String message = "User not found";
//            //request.setAttribute("informMessage", message);
//            page = PageName.ERROR_USER_PAGE;
//        }






//        UserRole role = UserRole.getUserRole(user);
//
//        if (role == UserRole.ADMIN) {
//            page = PageName.ERROR_USER_PAGE;
//        }
//
//        if (role == UserRole.CLIENT) {
//            page = PageName.MENU_LIST_PAGE;
//        }
//
//        session.setAttribute("user", user);
//
//        session.setAttribute("role", role);
        // add a Logger

//        if (user == null || !password.equals(user.getPassword())) {
//            return null;
//            // add a logic here with validator
//        } else {
//            UserRole userRole = UserRole.getUserRole(user);
//            if (userRole == UserRole.ADMIN) {
//                // go to the admin panel with list of orders
//                page = PageName.USER_PROFILE_PAGE;
//            }
//            if (userRole == UserRole.CLIENT) {
//                // go to the list menu with cars
//                page = PageName.LOGIN_PAGE;
//            }
//
//            session.setAttribute("user", user);
//            // add a log trace
//            // add a log info
//
//        }
        return page;
    }
}
