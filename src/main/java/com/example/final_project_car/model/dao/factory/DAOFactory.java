package com.example.final_project_car.model.dao.factory;

import com.example.final_project_car.model.dao.AccidentDAO;
import com.example.final_project_car.model.dao.CarDAO;
import com.example.final_project_car.model.dao.OrderDAO;
import com.example.final_project_car.model.dao.UserDAO;

public abstract class DAOFactory {
    public static final int MYSQL = 1;

    //public static final int ORACLE = 2;
    // here we can choose another RDBMS if we need

    public abstract AccidentDAO getAccidentDAO();

    public abstract CarDAO getCarDAO();

    public abstract OrderDAO getOrderDAO();

    public abstract UserDAO getUserDAO();

    public static DAOFactory getDAOFactory() {
        return MySqlDAOFactory.getInstance();
    }
}
