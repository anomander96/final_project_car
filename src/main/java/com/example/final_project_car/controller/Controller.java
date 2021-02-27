package com.example.final_project_car.controller;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.controller.command.CommandContainer;
import com.example.final_project_car.model.constants.PageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class Controller extends HttpServlet {
    private static final long serialVersionUID = -2584176172929444300L;
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String commandName = request.getParameter("command");

        Command command = CommandContainer.get(commandName);

        String page = command.execute(request, response);

        if (page != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(page);
            dispatcher.forward(request, response);
        }
    }






//        LOGGER.debug("Controller initialize");
//
//        String commandName = request.getParameter("command");
//        LOGGER.trace("Request parameter: command --> " + commandName);
//
//        Command command = CommandContainer.get(commandName);
//        LOGGER.trace("Obtained command --> " + command);
//
//        String redirectUrl = command.execute(request, response);
//
//        if ((command.isRedirect() && !redirectUrl.equals(PageName.ERROR_PAGE))) {
//            LOGGER.trace("Redirect address --> " + redirectUrl);
//            LOGGER.debug("Controller finished, now go to redirect address --> " + redirectUrl);
//
//            response.sendRedirect(request.getContextPath() + redirectUrl);
//        } else {
//            LOGGER.trace("Forward address --> " + redirectUrl);
//            LOGGER.debug("Controller finished, now go to forward address --> " + redirectUrl);
//
//            if (redirectUrl != null) {
//                RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
//                dispatcher.forward(request, response);
//            }
//
//        }

}
