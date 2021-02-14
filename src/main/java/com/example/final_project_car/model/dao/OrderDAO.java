package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Order;

import java.util.List;

public interface OrderDAO {
    public List<Order> getAllOrders();

    public Order getOrderById(int orderId);
}
