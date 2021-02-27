package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteUserCommand extends Command {
    private static final long serialVersionUID = 7599283102410267031L;
    private static final Logger LOGGER = LogManager.getLogger(DeleteUserCommand.class);
    private final UserService userService = new UserService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("user_id"));

        try {
           userService.deleteUser(userId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't delete user with this id");
        }
        page = PageName.ADMIN_PANEL;
        return page;
    }
}
