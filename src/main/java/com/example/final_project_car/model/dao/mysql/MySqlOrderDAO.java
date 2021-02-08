package com.example.final_project_car.model.dao.mysql;

import com.example.final_project_car.model.dao.OrderDAO;

public class MySqlOrderDAO implements OrderDAO {
    private static MySqlOrderDAO instance;
    public static MySqlOrderDAO getInstance() {
        if (instance == null) {
            instance = new MySqlOrderDAO();
        } return instance;
    }
}
