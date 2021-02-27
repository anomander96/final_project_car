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

public class BlockUserCommand extends Command {
    private static final long serialVersionUID = 6048292413207608096L;
    private static final Logger LOGGER = LogManager.getLogger(BlockUserCommand.class);
    private final UserService userService = new UserService();


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page;
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("user_id"));
        User user = null;

        try {
            user = userService.getUserById(userId);
        } catch (ServiceException e) {
            LOGGER.error("Couldn't extract user with such id");
        }


        if (user != null && !user.getIsBlocked()) {

            try {
                userService.blockUser(userId);
                LOGGER.info("User with id: {} successfully blocked", userId);
            } catch (ServiceException e) {
                LOGGER.error("Couldn't block this user");
            }
        } else {
            try {
                userService.unblockUser(userId);
                LOGGER.info("User with id: {} successfully unblocked", userId);
            } catch (ServiceException e) {
                LOGGER.error("Couldn't unblock this user");
            }
        }

        page = PageName.ADMIN_PANEL;

        return page;
    }
}
