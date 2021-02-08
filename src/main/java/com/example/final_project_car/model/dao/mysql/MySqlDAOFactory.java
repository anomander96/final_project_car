package com.example.final_project_car.model.dao.mysql;

import com.example.final_project_car.model.dao.*;

public class MySqlDAOFactory extends DAOFactory {
    private static MySqlDAOFactory instance;

    public static synchronized MySqlDAOFactory getInstance() {
        if (instance == null) {
            instance = new MySqlDAOFactory();
        } return instance;
    }

    @Override
    public AccidentDAO getAccidentDAO() {
        return MySqlAccidentDAO.getInstance();
    }

    @Override
    public CarDAO getCarDAO() {
        return MySqlCarDAO.getInstance();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return MySqlOrderDAO.getInstance();
    }

    @Override
    public UserDAO getUserDAO() {
        return MySqlUserDAO.getInstance();
    }
}
