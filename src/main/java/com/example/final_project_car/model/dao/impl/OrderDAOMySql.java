package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.OrderDAO;
import com.example.final_project_car.model.dao.builder.OrderDAOBuilder;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.DAOException;
import com.example.final_project_car.model.pool.ConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOMySql implements OrderDAO {
    private static OrderDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger(OrderDAOMySql.class);

    private static final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private static final String SELECT_ORDER_BY_ORDER_ID = "SELECT * FROM orders WHERE order_id = ?";
    private static final String SELECT_ORDER_BY_USER_ID = "SELECT * FROM orders INNER JOIN car ON orders.car_id = car.car_id WHERE user_id = ?";
    private static final String CHANGE_ORDER_STATUS_ON_APPROVED = "UPDATE orders SET order_status_id = 2 WHERE order_id = ";
    private static final String CHANGE_ORDER_STATUS_ON_DECLINED = "UPDATE orders SET order_status_id = 3 WHERE order_id =";
    private static final String CHANGE_ORDER_STATUS_ON_PAID = "UPDATE orders SET order_status_id = 4 WHERE order_id = ";
    private static final String CHANGE_ORDER_STATUS_ON_CLOSED = "UPDATE orders SET order_status_id = 5 WHERE order_id =";
    private static final String ADD_ORDER = "INSERT INTO orders (user_id, car_id, order_status_id, " +
            "with_driver, creation_date, rent_duration, total_price) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String ADD_DRIVER = "UPDATE orders SET with_driver = true WHERE order_id = ";
    private static final String GET_ORDER_BY_ORDER_ID = "SELECT * FROM orders WHERE order_id = ?";

    public static OrderDAOMySql getInstance() {
        if (instance == null) {
            instance = new OrderDAOMySql();
        }
        return instance;
    }

    @Override
    public List<Order> getAllOrders() throws DAOException {
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
            LOGGER.error("Database error! Couldn't get all orders", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return ordersContainer;
    }

    @Override
    public Order getOrderByOrderId(int orderId) throws DAOException {
        Order order = null;
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
            }
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't find order by order id", e);
            throw new DAOException(e);
        } finally {
            closeConnectionStatementAndResultSetAfterInvoke(connection, preparedStatement, resultSet);
        }
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) throws DAOException {
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
            LOGGER.error("Database error! Couldn't find order with this user id", e);
            throw new DAOException(e);
        } finally {
            closeConnectionStatementAndResultSetAfterInvoke(connection, preparedStatement, resultSet);
        }
        return ordersContainer;
    }

    @Override
    public void changeOrderStatusIdOnApproved(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_APPROVED + orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't change order status on approved", e);
            throw new DAOException(e);
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void changeOrderStatusIdOnDeclined(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_DECLINED + orderId);
            preparedStatement.executeUpdate();
        } catch(SQLException e) {
            LOGGER.error("Database error! Couldn't change order status on declined", e);
            throw new DAOException(e);
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void changeOrderStatusIdOnPaid(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_PAID + orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't change order status on paid", e);
            throw new DAOException(e);
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void changeOrderStatusIdOnClosed(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(CHANGE_ORDER_STATUS_ON_CLOSED + orderId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't change order status on closed", e);
            throw new DAOException(e);
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void addOrder(User user, Car car, boolean withDriver, int rentDuration) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setInt(2, car.getCarId());
            preparedStatement.setInt(3, 1);
            preparedStatement.setBoolean(4, withDriver);
            preparedStatement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(6, rentDuration);
            BigDecimal multiplyRentDuration = new BigDecimal(rentDuration);
            BigDecimal multiplyCarPrice = car.getPrice();
            BigDecimal totalPrice = multiplyRentDuration.multiply(multiplyCarPrice);
            preparedStatement.setBigDecimal(7, totalPrice);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't add new order", e);
            throw new DAOException(e);
        } finally {
            closeConnectionAndStatementAfterInvoke(connection, preparedStatement);
        }
    }

    @Override
    public void addADriver(int orderId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
           connection = connectionPool.getConnection();
           preparedStatement = connection.prepareStatement(ADD_DRIVER + orderId);
           preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Database error! Couldn't add a driver to order with such order id", e);
            throw new DAOException(e);
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
