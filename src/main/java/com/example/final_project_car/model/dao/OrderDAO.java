package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.DAOException;

import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders() throws DAOException;

    public Order getOrderByOrderId(int orderId) throws DAOException;

    public List<Order> getOrdersByUserId(int userId) throws DAOException;

    public void changeOrderStatusIdOnApproved(int orderId) throws DAOException;

    public void changeOrderStatusIdOnDeclined(int orderId) throws DAOException;

    public void changeOrderStatusIdOnPaid(int orderId) throws DAOException;

    public void changeOrderStatusIdOnClosed(int orderId) throws DAOException;

    public void addOrder(User user, Car car, boolean withDriver, int rentDuration) throws DAOException;

    public void addADriver(int orderId) throws DAOException;


}
