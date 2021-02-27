package com.example.final_project_car.controller.filters;

import com.example.final_project_car.model.constants.AttributeName;
import com.example.final_project_car.model.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdministratorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(AttributeName.USER);
        if (user != null && user.getUserRoleId() == 2) {
            session.setAttribute("active_admin", true);
        }
        filterChain.doFilter(request, response);
    }
}
