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

public class UserProfileCommand extends Command {
    private static final long serialVersionUID = 8080058511916438013L;
    private static final Logger LOGGER = LogManager.getLogger(UserProfileCommand.class);
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;

        HttpSession httpSession = request.getSession();
        int userId = (int) httpSession.getAttribute("user_id");

        try {
            User user;
            user = userService.getUserById(userId);
            request.setAttribute("user", user);
        } catch (ServiceException e) {
           LOGGER.error("Couldn't find User with id: {}", userId);
        }
        page = PageName.USER_PROFILE_PAGE;
        return page;
    }
}
