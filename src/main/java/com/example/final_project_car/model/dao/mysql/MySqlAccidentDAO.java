package com.example.final_project_car.model.dao.mysql;

import com.example.final_project_car.model.dao.AccidentDAO;

public class MySqlAccidentDAO implements AccidentDAO {
    private static MySqlAccidentDAO instance;

    public static MySqlAccidentDAO getInstance() {
        if (instance == null) {
            instance = new MySqlAccidentDAO();
        } return instance;
    }
}
