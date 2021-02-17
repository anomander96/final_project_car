package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.OrderDAO;
import com.example.final_project_car.model.dao.builder.OrderDAOBuilder;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.pool.ConnectionPool;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOMySql implements OrderDAO {
    private static OrderDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SELECT_ORDER_BY_ORDER_ID = "SELECT * FROM orders WHERE order_id = ?";
    private static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders INNER JOIN car ON orders.car_id = car.car_id WHERE user_id = ?";
    private static final String CHANGE_ORDER_STATUS_ON_APPROVED = "UPDATE orders SET order_status_id = 2 WHERE order_id = ";
    private static final String CHANGE_ORDER_STATUS_ON_DECLINED = "UPDATE orders SET order_status_id = 3 WHERE order_id =";
    private static final String CHANGE_ORDER_STATUS_ON_PAID = "UPDATE orders SET order_status_id = 4 WHERE order_id = ";
    private static final String CHANGE_ORDER_STATUS_ON_CLOSED = "UPDATE orders SET order_status_id = 5 WHERE order_id =";
    private static final String ADD_ORDER = "INSERT INTO orders (user_id, car_id, order_status_id, create_date, " +
            "with_driver, rent_duration, total_price) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String ADD_DRIVER = "UPDATE orders SET with_driver = true WHERE order_id = ";

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
    public Order getOrderByOrderId(int orderId) {
        Order order;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ORDER_ID);
            preparedStatement.setInt(1, orderId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                OrderDAOBuilder builder = new OrderDAOBuilder();
                order = builder.build(resultSet);
                return order;
            }
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            closeConnectionStatementAndResultSetAfterInvoke(connection, preparedStatement, resultSet);
        }
        return null;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> ordersContainer = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Order order;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                OrderDAOBuilder builder = new OrderDAOBuilder();
                order = builder.build(resultSet);
                ordersContainer.add(order);
            }

        } catch (SQLException e) {
            // add a Logger and a custom Exception
        } finally {
            closeConnectionStatementAndResultSetAfterInvoke(connection, preparedStatement, resultSet);
        }
        return ordersContainer;
    }

    @Override
    public void changeOrderStatusIdOnApproved(int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_APPROVED + orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a Logger here and a custom Exception
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void changeOrderStatusIdOnDeclined(int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_DECLINED + orderId);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            // add a Logger and a custom exception
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void changeOrderStatusIdOnPaid(int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_PAID + orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a Logger and a custom Exception here
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void changeOrderStatusIdOnClosed(int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_CLOSED + orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a logger and a custom Exception
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void addOrder(User user, Car car, int rentDuration) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            Date date = new Date(System.currentTimeMillis());
            preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, car.getCarId());
            preparedStatement.setInt(3, 1);
            preparedStatement.setDate(4, date);
            preparedStatement.setBoolean(5, false);
            preparedStatement.setInt(6, rentDuration);
            preparedStatement.setBigDecimal(7, car.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a Logger and a custom Exception
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void addADriver(int orderId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
           connection = connectionPool.getConnection();
           preparedStatement = connection.prepareStatement(ADD_DRIVER + orderId);
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a Logger and a custom Exception
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
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
