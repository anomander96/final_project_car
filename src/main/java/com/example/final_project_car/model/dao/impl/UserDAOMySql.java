package com.example.final_project_car.model.dao.impl;

import com.example.final_project_car.model.dao.UserDAO;
import com.example.final_project_car.model.dao.builder.UserDAOBuilder;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOMySql implements UserDAO {
    private static UserDAOMySql instance;
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

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
    public List<User> getAllUsers() {
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
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return usersContainer;
    }

    @Override
    public User getUserById(int userId) {
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
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
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
        } catch(SQLException e) {
            // add a Logger here
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement, resultSet);
            }
        }
        return user;
    }

    @Override
    public void registerUser(User newUser) {
        User user = null;
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
        } catch (SQLException e) {
            // add a Logger
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }

    @Override
    public void addNewUser(User user) {
        //boolean result = false;
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
                //result = true;
            }
        } catch (SQLException e) {
            // add a Logger here and a custom Exception
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }


    @Override
    public void blockUser(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(BLOCK_USER + userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a Logger and custom Exception
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
    }

    @Override
    public void unblockUser(int userId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionPool.getConnection();
            preparedStatement = connection.prepareStatement(UNBLOCK_USER + userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // add a Logger and custom Exception
        }
    }


    @Override
    public boolean delete(Integer userId) {
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
            }
        } catch (SQLException e) {
            System.out.println("Should add a Logger");
        } finally {
            if (connection != null) {
                connectionPool.closeConnection(connection, preparedStatement);
            }
        }
        return result;
    }

//    public static void main(String[] args) {
//
//
//        //User user = new User("andrew", "roman");
//        //User user = user.createUser("roman", "borin", "borabora", "qwerty","borin@gmail.com", "444", "3434");
//        UserDAOMySql userDAOMySql = new UserDAOMySql();
//        User user = userDAOMySql.getUserByLogin("hello");
//        System.out.println(user.toString());
//    }
}
