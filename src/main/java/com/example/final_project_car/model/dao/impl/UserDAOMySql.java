package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.UserDAO;

public class UserDAOMySql implements UserDAO {
    private static UserDAOMySql instance;

    public static UserDAOMySql getInstance() {
        if (instance == null) {
            instance = new UserDAOMySql();
        } return instance;
    }
}
