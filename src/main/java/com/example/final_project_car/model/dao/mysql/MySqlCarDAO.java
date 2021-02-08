package com.example.final_project_car.model.dao.mysql;

import com.example.final_project_car.model.dao.CarDAO;

public class MySqlCarDAO implements CarDAO {
    private static MySqlCarDAO instance;

    public static MySqlCarDAO getInstance() {
        if (instance == null) {
            instance = new MySqlCarDAO();
        } return instance;
    }
}
