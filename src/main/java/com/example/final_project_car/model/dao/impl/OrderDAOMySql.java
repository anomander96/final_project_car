package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.OrderDAO;

public class OrderDAOMySql implements OrderDAO {
    private static OrderDAOMySql instance;
    public static OrderDAOMySql getInstance() {
        if (instance == null) {
            instance = new OrderDAOMySql();
        } return instance;
    }
}
