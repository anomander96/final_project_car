package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.CarDAO;
import com.example.final_project_car.model.dao.builder.CarDAOBuilder;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.exception.DAOException;
import com.example.final_project_car.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAOMySql implements CarDAO {
    private static CarDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(CarDAOMySql.class);

    private static final String SELECT_ALL_CARS = "SELECT * FROM car";
    private static final String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE car_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM car WHERE car_id = ?";
    private static final String UPDATE_CAR = "UPDATE car SET car_category_id = ?, brand_name = ?, model_name = ?" +
            ", color = ?, price = ? WHERE car_id = ?";
    private static final String INSERT_CAR = "INSERT INTO car (car_category_id, brand_name, model_name, color, price)" +
            " VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_CAR_CATEGORY = "UPDATE car SET car_category_id = ? WHERE car_id = ?";
    private static final String SELECT_CARS_WITH_LIMIT = "SELECT * FROM car LIMIT ?, ?";
    private static final String GET_NUMBER_OF_ROWS = "SELECT COUNT(car_id) FROM car";

    public static CarDAOMySql getInstance() {
        if (instance == null) {
            instance = new CarDAOMySql();
        }
        return instance;
    }

    @Override
    public List<Car> getAllCars() throws DAOException {
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
            LOGGER.error("Database error! Couldn't retrieve all cars!", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return carContainer;
    }

    @Override
    public Car getCarById(int carId) throws DAOException {
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
            LOGGER.error("Database error! Couldn't find a car with this car id", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return car;
    }

    @Override
    public boolean delete(Integer carId) throws DAOException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        if (carId != null) {
            try {
                connection = connectionPool.getConnection();
                preparedStatement = connection.prepareStatement(DELETE_QUERY);
                preparedStatement.setInt(1, carId);
                preparedStatement.executeUpdate();
                result = true;
            } catch (SQLException e) {
                LOGGER.error("Database error! Couldn't delete a car", e);
                throw new DAOException(e);
            } finally {
                if (connection != null) {
                    connectionPool.closeConnection(connection, preparedStatement);
                }
            }
        }
        return result;
    }

    @Override
    public void update(Car car) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_CAR);
            preparedStatement.setInt(1, car.getCarCategoryId());
            preparedStatement.setString(2, car.getBrandName());
            preparedStatement.setString(3, car.getModelName());
            preparedStatement.setString(4, car.getColor());
            preparedStatement.setBigDecimal(5, car.getPrice());
            preparedStatement.setInt(6, car.getCarId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't update car", e);
            throw new DAOException(e);

        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }

    @Override
    public void addNewCar(Car car) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            if (car != null) {
                preparedStatement = connection.prepareStatement(INSERT_CAR);
                preparedStatement.setInt(1, car.getCarCategoryId());
                preparedStatement.setString(2, car.getBrandName());
                preparedStatement.setString(3, car.getModelName());
                preparedStatement.setString(4, car.getColor());
                preparedStatement.setBigDecimal(5, car.getPrice());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't add a new car", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }

    @Override
    public List<Car> findCars(int currentPage, int recordsPerPage) throws DAOException {
        List<Car> cars = new ArrayList<>();
        int start = currentPage * recordsPerPage - recordsPerPage;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_CARS_WITH_LIMIT);
            preparedStatement.setInt(1, currentPage);
            preparedStatement.setInt(2, recordsPerPage);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                CarDAOBuilder builder = new CarDAOBuilder();
                Car car = builder.build(resultSet);
                cars.add(car);
            }
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't find all needed cars for pagination", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        } return cars;
    }

    @Override
    public Integer getNumberOfRows() throws DAOException {
        Integer numberOfRows = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(GET_NUMBER_OF_ROWS);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                numberOfRows = resultSet.getInt(1);
            }

        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't get number of rows in table for pagination", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        } return numberOfRows;
    }
}
