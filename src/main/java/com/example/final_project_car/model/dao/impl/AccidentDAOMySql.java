package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.AccidentDAO;
import com.example.final_project_car.model.dao.builder.AccidentDAOBuilder;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccidentDAOMySql implements AccidentDAO {
    private static AccidentDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SELECT_ALL_ACCIDENTS = "SELECT * FROM accident";
    private static final String SELECT_ACCIDENT_BY_ID = "SELECT * FROM accident WHERE accident_id = ?";

    public static AccidentDAOMySql getInstance() {
        if (instance == null) {
            instance = new AccidentDAOMySql();
        } return instance;
    }

    @Override
    public List<Accident> getAllAccidents() {
        List<Accident> accidentsContainer = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_ACCIDENTS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                AccidentDAOBuilder builder = new AccidentDAOBuilder();
                Accident accident = builder.build(resultSet);
                accidentsContainer.add(accident);
            }

        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return accidentsContainer;
    }

    @Override
    public Accident getAccidentById(int accidentId) {
        Accident accident = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ACCIDENT_BY_ID);
            preparedStatement.setInt(1, accidentId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                AccidentDAOBuilder builder = new AccidentDAOBuilder();
                accident = builder.build(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return accident;
    }
}
