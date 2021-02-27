package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.CarDAO;
import com.example.final_project_car.model.dao.OrderDAO;
import com.example.final_project_car.model.dao.UserDAO;
import com.example.final_project_car.model.dao.impl.CarDAOMySql;
import com.example.final_project_car.model.dao.impl.OrderDAOMySql;
import com.example.final_project_car.model.dao.impl.UserDAOMySql;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.DAOException;
import com.example.final_project_car.model.exception.ServiceException;

import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO = new OrderDAOMySql();
    private final UserDAO userDAO = new UserDAOMySql();
    private final CarDAO carDAO = new CarDAOMySql();

    public List<Order> getAllOrders() throws ServiceException {
        try {
           return orderDAO.getAllOrders();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Order> getOrdersByUserId(int userId) throws ServiceException {
        List<Order> ordersContainer = new ArrayList<>();
        try {
            ordersContainer = orderDAO.getOrdersByUserId(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return ordersContainer;
    }

    public Order getOrderByOrderId(int orderId) throws ServiceException {
        Order order = null;
        try {
            order = orderDAO.getOrderByOrderId(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return order;
    }

    public void changeOrderStatusIdOnApproved(int orderId) throws ServiceException {
        try {
            orderDAO.changeOrderStatusIdOnApproved(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void changeOrderStatusIdOnDeclined(int orderId) throws ServiceException {
        try {
            orderDAO.changeOrderStatusIdOnDeclined(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void changeOrderStatusIdOnPaid(int orderId) throws ServiceException {
        try {
            orderDAO.changeOrderStatusIdOnPaid(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void changeOrderStatusIdOnClosed(int orderId) throws ServiceException {
        try {
            orderDAO.changeOrderStatusIdOnClosed(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void createOrderByUser(int userId, int carId, boolean withDriver, int rentDuration) throws ServiceException {
        User user = null;
        Car car = null;

        try {
            user = userDAO.getUserById(userId);
        } catch (DAOException e) {
           throw new ServiceException(e);
        }

        try {
            car = carDAO.getCarById(carId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        try {
            orderDAO.addOrder(user, car, withDriver, rentDuration);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void addDriver(int orderId) throws ServiceException {
        try {
            orderDAO.addADriver(orderId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
