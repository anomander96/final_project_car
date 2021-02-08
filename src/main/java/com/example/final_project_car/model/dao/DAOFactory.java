package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.dao.mysql.MySqlDAOFactory;

public abstract class DAOFactory {
    public static final int MYSQL = 1;

    //public static final int ORACLE = 2;
    // here we can choose another RDBMS if we need

    public abstract AccidentDAO getAccidentDAO();

    public abstract CarDAO getCarDAO();

    public abstract  OrderDAO getOrderDAO();

    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory() {
        return MySqlDAOFactory.getInstance();
    }
}
