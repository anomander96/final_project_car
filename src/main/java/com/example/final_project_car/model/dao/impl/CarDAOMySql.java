package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.CarDAO;
import com.example.final_project_car.model.dao.builder.CarDAOBuilder;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOMySql implements CarDAO {
    private static CarDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SELECT_ALL_CARS = "SELECT * FROM car";
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE car_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM car WHERE car_id = ?";

    public static CarDAOMySql getInstance() {
        if (instance == null) {
            instance = new CarDAOMySql();
        } return instance;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> carContainer = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_CARS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                CarDAOBuilder builder = new CarDAOBuilder();
                Car car = builder.build(resultSet);
                carContainer.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Should use a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return carContainer;
    }

    @Override
    public Car getCarById(int carId) {
        Car car = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CAR_BY_ID);
            preparedStatement.setInt(1, carId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                CarDAOBuilder builder = new CarDAOBuilder();
                car = builder.build(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Should use a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return car;
    }

    @Override
    public boolean delete(Integer carId) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        if (carId != null) {
            try {
                connection = connectionPool.getConnection();
                preparedStatement = connection.prepareStatement(DELETE_QUERY);
                preparedStatement.setInt(1 , carId);
                preparedStatement.executeUpdate();
                result = true;
            } catch (SQLException e) {
                System.out.println("Should add a Logger");
            } finally {
                if (connection != null) {
                    connectionPool.closeConnection(connection, preparedStatement, resultSet);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CarDAOMySql manager = new CarDAOMySql();
        System.out.println(manager.delete(2));
    }
}
