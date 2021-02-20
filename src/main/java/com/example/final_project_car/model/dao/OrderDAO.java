package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.entity.User;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface OrderDAO {

    public List<Order> getAllOrders(); // for admin

    public Order getOrderByOrderId(int orderId);

    public List<Order> getOrdersByUserId(int userId); // for client

    public void changeOrderStatusIdOnApproved(int orderId);

    public void changeOrderStatusIdOnDeclined(int orderId);

    public void changeOrderStatusIdOnPaid(int orderId);

    public void changeOrderStatusIdOnClosed(int orderId);

    public void addOrder(User user, Car car, boolean withDriver, int rentDuration);

    public void addADriver(int orderId);


}
