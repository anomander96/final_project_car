package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.OrderDAO;
import com.example.final_project_car.model.dao.builder.OrderDAOBuilder;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOMySql implements OrderDAO {
    private static OrderDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE order_id = ?";

    public static OrderDAOMySql getInstance() {
        if (instance == null) {
            instance = new OrderDAOMySql();
        }
        return instance;
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> ordersContainer = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderDAOBuilder builder = new OrderDAOBuilder();
                Order order = builder.build(resultSet);
                ordersContainer.add(order);
            }
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return ordersContainer;
    }

    @Override
    public Order getOrderById(int orderId) {
        Order order = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);
            preparedStatement.setInt(1, orderId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                OrderDAOBuilder builder = new OrderDAOBuilder();
                order = builder.build(resultSet);
            }
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return order;
    }

}
