package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand extends Command {
    private static final long serialVersionUID = 7578654847871496658L;
    private static final Logger LOGGER = LogManager.getLogger(LoginCommand.class);
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = PageName.LOGIN_PAGE;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = null;

        try {
            user = userService.signIn(login, password);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't sign in user");
        }

        if (user != null) {
            HttpSession session = request.getSession();
            request.setAttribute("user", user);
            try {
                user = userService.getUserByLogin(login);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            int id = user.getUserId();
            session.setAttribute("user_id", id);
            session.setAttribute("user", user);
            if (user.getUserRoleId() == 1) {
                page = PageName.MENU_LIST_PAGE;
            } else {
                page = PageName.ADMIN_PANEL;
            }
        }
        return page;
    }

}

