package com.example.final_project_car.model.dao.mysql;

import com.example.final_project_car.model.dao.UserDAO;

public class MySqlUserDAO implements UserDAO {
    private static MySqlUserDAO instance;

    public static MySqlUserDAO getInstance() {
        if (instance == null) {
            instance = new MySqlUserDAO();
        } return instance;
    }
}
