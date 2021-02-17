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

import java.sql.Array;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final OrderDAO orderDAO = new OrderDAOMySql();
    private final UserDAO userDAO = new UserDAOMySql();
    private final CarDAO carDAO = new CarDAOMySql();
//0.+++    public List<Order> getAllOrders();
//
//1.    public Order getOrderByOrderId(int orderId);
//
//3.+++    public Order getOrderByUserId(int userId);
//
//4.+++    public void changeOrderStatusIdOnApproved(int orderId);
//
//5.+++    public void changeOrderStatusIdOnDeclined(int orderId);
//
//6.+++    public void changeOrderStatusIdOnPaid(int orderId);
//
//7.+++    public void changeOrderStatusIdOnClosed(int orderId);

    //8. +++  public void createOrderByUser()

    public List<Order> getAllOrders() throws Exception { // add a custom Exception signature
        try {
           return orderDAO.getAllOrders();
        } catch (Exception e) {
            // add a Logger and a custom Exception
            throw new Exception(e);
        }
    }

    public List<Order> getOrdersByUserId(int userId) {
        List<Order> ordersContainer = new ArrayList<>();
        try {
            ordersContainer = orderDAO.getOrdersByUserId(userId);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }
        return ordersContainer;
    }

    public void changeOrderStatusIdOnApproved(int orderId) {
        try {
            orderDAO.changeOrderStatusIdOnApproved(orderId);
        } catch (Exception e) {
            // add a Logger and a Custom Exception
        }
    }

    public void changeOrderStatusIdOnDeclined(int orderId) {
        try {
            orderDAO.changeOrderStatusIdOnDeclined(orderId);
        } catch (Exception e) {
            // add a Logger and a custom Exception here
        }
    }

    public void changeOrderStatusIdOnPaid(int orderId) {
        try {
            orderDAO.changeOrderStatusIdOnPaid(orderId);
        } catch (Exception e) {
            // add a Logger and custom Exception
        }
    }

    public void changeOrderStatusIdOnClosed(int orderId) {
        try {
            orderDAO.changeOrderStatusIdOnClosed(orderId);
        } catch (Exception e) {
            // add a Logger and a custom exception here
        }
    }

    public void createOrderByUser(int userId, int carId, int rentDuration) {
        User user = null;
        Car car = null;

        try {
            user = userDAO.getUserById(userId);
        } catch (Exception e) {
            // add a logger and a custom Exception
        }

        try {
            car = carDAO.getCarById(carId);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }

        try {
            orderDAO.addOrder(user, car, rentDuration);
        } catch (Exception e) {
            // add a Logger and a custom exception
        }
    }

    public void addDriver(int orderId) {
        try {
            orderDAO.addADriver(orderId);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }
    }



}
