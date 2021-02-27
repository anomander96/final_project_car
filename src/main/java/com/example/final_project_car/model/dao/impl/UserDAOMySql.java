package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.UserDAO;
import com.example.final_project_car.model.dao.builder.UserDAOBuilder;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.ConnectionPoolException;
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

public class UserDAOMySql implements UserDAO {
    private static UserDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final Logger LOGGER = LogManager.getLogger();

    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE user_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM user WHERE user_id = ?";
    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM user WHERE login = ?";
    private static final String REGISTER_USER = "INSERT INTO user (first_name, last_name, login, password," +
            " email, phone, passport, is_blocked) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String BLOCK_USER = "UPDATE user SET is_blocked = true WHERE user_id = ";
    private static final String UNBLOCK_USER = "UPDATE user SET is_blocked = false WHERE user_id = ";
    private static final String INSERT_NEW_USER = "INSERT INTO user (user_role_id, first_name, last_name, login, password," +
            " email, phone, passport, is_blocked) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static UserDAOMySql getInstance() {
        if (instance == null) {
            instance = new UserDAOMySql();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() throws DAOException {
        List<User> usersContainer = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserDAOBuilder builder = new UserDAOBuilder();
                User user = builder.build(resultSet);
                usersContainer.add(user);
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't get all users", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return usersContainer;
    }

    @Override
    public User getUserById(int userId) throws DAOException {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UserDAOBuilder builder = new UserDAOBuilder();
                user = builder.build(resultSet);
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't find user with such user id", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) throws DAOException {
        User user = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                UserDAOBuilder builder = new UserDAOBuilder();
                user = builder.build(resultSet);
            }
        } catch(SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't find user with such login", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public void registerUser(User newUser) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(REGISTER_USER);
            preparedStatement.setString(1, newUser.getFirstName());
            preparedStatement.setString(2, newUser.getLastName());
            preparedStatement.setString(3, newUser.getLogin());
            preparedStatement.setString(4, newUser.getPassword());
            preparedStatement.setString(5, newUser.getEmail());
            preparedStatement.setString(6, newUser.getPhone());
            preparedStatement.setString(7, newUser.getPassport());
            preparedStatement.setBoolean(8, newUser.getIsBlocked());
            preparedStatement.executeUpdate();
            LOGGER.info("User: {} successfully added to database", newUser.getLogin());
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't register user", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }

    @Override
    public void addNewUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = connectionPool.getConnection();
            if (user != null) {
                preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
                preparedStatement.setInt(1, user.getUserRoleId());
                preparedStatement.setString(2, user.getFirstName());
                preparedStatement.setString(3, user.getLastName());
                preparedStatement.setString(4, user.getLogin());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.setString(6, user.getEmail());
                preparedStatement.setString(7, user.getPhone());
                preparedStatement.setString(8, user.getPassport());
                preparedStatement.setBoolean(9, false);
                preparedStatement.executeUpdate();
                LOGGER.info("User: {} successfully added to database", user.getLogin());
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't add a new user", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }


    @Override
    public void blockUser(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(BLOCK_USER + userId);
            preparedStatement.executeUpdate();
            LOGGER.info("User with id: {} successfully blocked", userId);
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't block user", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }

    @Override
    public void unblockUser(int userId) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(UNBLOCK_USER + userId);
            preparedStatement.executeUpdate();
            LOGGER.info("User with id: {} successfully unblocked to database", userId);
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't unblock user", e);
            throw new DAOException(e);
        }
    }


    @Override
    public boolean delete(Integer userId) throws DAOException {
        boolean result = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            if (userId != null) {
                connection = connectionPool.getConnection();
                preparedStatement = connection.prepareStatement(DELETE_QUERY);
                preparedStatement.setInt(1, userId);
                preparedStatement.executeUpdate();
                result = true;
                LOGGER.info("User with id: {} successfully deleted from database", userId);
            }
        } catch (SQLException | ConnectionPoolException e) {
            LOGGER.error("Database error! Couldn't delete user", e);
            throw new DAOException(e);
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
        return result;
    }
}
