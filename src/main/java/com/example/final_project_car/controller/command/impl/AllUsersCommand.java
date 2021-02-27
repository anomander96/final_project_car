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
import java.util.List;

public class AllUsersCommand extends Command {
    private static final long serialVersionUID = 4772155496534923190L;
    private static final Logger LOGGER = LogManager.getLogger(AllUsersCommand.class);
    private UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = null;
        HttpSession session = request.getSession();

        List<User> users = null;

        try {
            users = userService.getAllUsers();
        } catch (ServiceException e) {
            LOGGER.error("Error occurred while getting all users");
        }

        request.setAttribute("users", users);
        page = PageName.ALL_USERS;
        return page;
    }
}
