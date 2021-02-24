package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.AccidentDAO;
import com.example.final_project_car.model.dao.builder.AccidentDAOBuilder;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.model.pool.ConnectionPool;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AccidentDAOMySql implements AccidentDAO {
    private static AccidentDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SELECT_ALL_ACCIDENTS = "SELECT * FROM accident";
    private static final String SELECT_ACCIDENT_BY_ID = "SELECT * FROM accident WHERE accident_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM accident WHERE accident_id = ?";
    private static final String ADD_ACCIDENT = "INSERT INTO accident (accident_category_id, order_id, description, accident_time, cost_per_damage) " +
            "VALUES (?, ?, ?, ?, ?);";

    public static AccidentDAOMySql getInstance() {
        if (instance == null) {
            instance = new AccidentDAOMySql();
        }
        return instance;
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
            closeConnectionStatementAndResultSetAfterInvoke(connection, preparedStatement, resultSet);
        }
        return accidentsContainer;
    }

    @Override
    public Accident getAccidentById(int accidentId) {
        Accident accident = new Accident();
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
            closeConnectionStatementAndResultSetAfterInvoke(connection, preparedStatement, resultSet);
        }
        return accident;
    }

    @Override
    public boolean delete(Integer accidentId) {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            if (accidentId != null) {
                connection = connectionPool.getConnection();
                preparedStatement = connection.prepareStatement(DELETE_QUERY);
                preparedStatement.setInt(1, accidentId);
                preparedStatement.executeUpdate();
                result = true;
            }
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
        return result;
    }

    @Override
    public void add(Accident accident) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (accident != null) {
            try {
                connection = connectionPool.getConnection();
                preparedStatement = connection.prepareStatement(ADD_ACCIDENT);
                preparedStatement.setInt(1, accident.getAccidentCategoryId());
                preparedStatement.setInt(2, accident.getOrderId());
                preparedStatement.setString(3, accident.getDescription());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.setBigDecimal(5, accident.getCostPerDamage());
                preparedStatement.executeUpdate();
                // add a logger here about success adding
            } catch (SQLException e) {
                // add a Logger and a custom Exception
            } finally {
                closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
            }
        }
    }

    private void closeConnectionAndStatementAfterInvoke(Connection connection, PreparedStatement preparedStatement) {
        if (connection != null) {
            connectionPool.closeConnection(connection, preparedStatement);
        }
    }

    private void closeConnectionStatementAndResultSetAfterInvoke(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        if (connection != null) {
            connectionPool.closeConnection(connection, preparedStatement, resultSet);
        }
    }
}
