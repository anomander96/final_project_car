package com.example.final_project_car.controller;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.controller.command.CommandContainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {

    private static final long serialVersionUID = -2584176172929444300L;
    //private static final CommandFactory

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // add a logger

        String commandName = request.getParameter("command");
        // add a log trace

        Command command = CommandContainer.get(commandName);
        // add a log trace

        String forward = command.execute(request, response);
        // add a log trace

        if (forward != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
            dispatcher.forward(request, response);
        }
    }
}
