package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CarsListCommand extends Command {
    private static final long serialVersionUID = -7095101596672606605L;
    private static final Logger LOGGER = LogManager.getLogger(CarsListCommand.class);
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;
        HttpSession httpSession = request.getSession();

        int pageNumber = 1;
        int recordsPerPage = 10;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }

        List<Car> cars = null;
        int numberOfRecords = 0;

        try {
            cars = carService.findCarsForPagination((pageNumber - 1) * recordsPerPage, recordsPerPage);
            numberOfRecords = carService.getNumberOfRows();
            LOGGER.info("Cars successfully founded for pagination on page");
        } catch (ServiceException e) {
            LOGGER.error("Couldn't get cars for pagination");
        }

        int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / recordsPerPage);

        request.setAttribute("cars", cars);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", pageNumber);
        page = PageName.CARS_LIST_PAGE;

        return page;
    }
}
