package com.example.final_project_car.model.dao.factory;

import com.example.final_project_car.model.dao.*;
import com.example.final_project_car.model.dao.impl.AccidentDAOMySql;
import com.example.final_project_car.model.dao.impl.CarDAOMySql;
import com.example.final_project_car.model.dao.impl.OrderDAOMySql;
import com.example.final_project_car.model.dao.impl.UserDAOMySql;

public class MySqlDAOFactory extends DAOFactory {
    private static MySqlDAOFactory instance;

    public static synchronized MySqlDAOFactory getInstance() {
        if (instance == null) {
            instance = new MySqlDAOFactory();
        } return instance;
    }

    @Override
    public AccidentDAO getAccidentDAO() {
        return AccidentDAOMySql.getInstance();
    }

    @Override
    public CarDAO getCarDAO() {
        return CarDAOMySql.getInstance();
    }

    @Override
    public OrderDAO getOrderDAO() {
        return OrderDAOMySql.getInstance();
    }

    @Override
    public UserDAO getUserDAO() {
        return UserDAOMySql.getInstance();
    }
}
