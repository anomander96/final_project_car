package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.controller.validator.DataValidator;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrationCommand extends Command {
    private static final long serialVersionUID = 8458030426649305346L;
    private static final Logger LOGGER = LogManager.getLogger(RegistrationCommand.class);
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = PageName.SIGN_UP_PAGE;
        User user = null;
        String firstName = request.getParameter(Parameters.FIRST_NAME);
        String lastName = request.getParameter(Parameters.LAST_NAME);
        String login = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
        String email = request.getParameter(Parameters.EMAIL);
        String phone = request.getParameter(Parameters.PHONE);
        String passport = request.getParameter(Parameters.PASSPORT);

        Map<String, String> userData = new HashMap<>();
        userData.put(Parameters.FIRST_NAME, firstName);
        userData.put(Parameters.LAST_NAME, lastName);
        userData.put(Parameters.LOGIN, login);
        userData.put(Parameters.PASSWORD, password);
        userData.put(Parameters.EMAIL, email);
        userData.put(Parameters.PHONE, phone);

        if (DataValidator.validateUserData(userData)) {
            try {
                userService.createUser(firstName, lastName, login, password, email, phone, passport);
            } catch (ServiceException e) {
                LOGGER.error("Error occurred while registering new user");
                page = PageName.ERROR_USER_PAGE;
                return page;
            }
            try {
                user = userService.getUserByLogin(login);
            } catch (ServiceException e) {
                LOGGER.error("Couldn't find user with such login");
            }
            HttpSession session = request.getSession();
            if (user != null) {
                int userId = user.getUserId();
                session.setAttribute("user_id", userId);
                session.setAttribute("user", user);
                page = PageName.MENU_LIST_PAGE;
            }
        } else {
            LOGGER.error("User fill form with invalid data");
            page = PageName.SIGN_UP_PAGE;
        }
        return page;
    }
}
