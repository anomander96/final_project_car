package com.example.final_project_car.controller.command.impl;

import com.example.final_project_car.controller.command.Command;
import com.example.final_project_car.model.constants.PageName;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.service.CarService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CarsListCommand extends Command {
    private static final long serialVersionUID = -7095101596672606605L;
    private final CarService carService = new CarService();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        HttpSession httpSession = request.getSession();


        // here started a new code
//        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
//        int recordsPerPage = Integer.parseInt(request.getParameter("recordsPerPage"));
//
//        List<Car> cars = carService.findCarsForPagination(currentPage, recordsPerPage);
//        request.setAttribute("cars", cars);
//
//        int rows = carService.getNumberOfRows();
//        int numberOfPages = rows / recordsPerPage;
//
//        if (numberOfPages % recordsPerPage > 0) {
//            numberOfPages++;
//        }
//
//        request.setAttribute("numberOfPages", numberOfPages);
//        request.setAttribute("currentPage", currentPage);
//        request.setAttribute("recordsPerPage", recordsPerPage);
//
//        page = PageName.CARS_LIST_PAGE;



        int pageNumber = 1;
        int recordsPerPage = 10;
        if (request.getParameter("pageNumber") != null) {
            pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        }

        List<Car> cars = carService.findCarsForPagination((pageNumber - 1) * recordsPerPage, recordsPerPage);
        int numberOfRecords = carService.getNumberOfRows();
        int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / recordsPerPage);

        request.setAttribute("cars", cars);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", pageNumber);
        page = PageName.CARS_LIST_PAGE;

        // end of new code

//        List<Car> cars = null;
//
//        try {
//            cars = carService.getAllCars();
//        } catch (Exception e) {
//            // add a logger and or an inform message with custom exception
//        }
//
//        request.setAttribute("cars", cars);
//        page = PageName.CARS_LIST_PAGE;
        return page;
    }
}
