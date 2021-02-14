package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.UserDAO;
import com.example.final_project_car.model.dao.impl.UserDAOMySql;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.service.builder.UserServiceBuilder;

import java.util.List;

public class UserService {

        //0.+++    public List<User> getAllUsers(); --> вкликаємо з DAO
        //1.+++    public User signIn(String login, String password);
        //2.+++    public void createUser(String s);
        //3.+++    public User getUserByLogin(String login) --> викликаємо з DAO
        //4.+++    public User getUserById(int id) --> викликаємо з DAO
        //5.+++    public User deleteUser(int userId) --> викликаємо з DAO
        //5.    public void changePassword(long userID, String oldPassword, String newPassword, String repeatPassword)
        //6.+++    public void blockUser(int userId); --> викликаємо з DAO
        //7.+++    public void unblockUser(int userId) --> викликаємо з DAO

    private final UserDAO userDAO = UserDAOMySql.getInstance();

    public List<User> getAllUsers() throws Exception { // add an UserServiceException here
        try {
            return userDAO.getAllUsers();
        } catch (Exception e) {
            // add a Logger here
            System.out.println(e.getMessage());
            throw new Exception(e);
        }
    }

    public User signIn(String login, String password) throws Exception { // add a correct new UserServiceException
        User user = null;

        // add a validation here
        //if (LoginPasswordValidator.validationLogin(login) && LoginPasswordValidator.validationPassword(password))

        try {
            user = userDAO.getUserByLogin(login);
        } catch (Exception e) {
            throw new Exception(e);
        }

        if (user.getLogin() != null && !user.getIsBlocked()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void createUser(String firstName, String lastName, String login,
                           String password, String email, String phone, String passport) {

        // here we need to add a validators for login and password and passport mb

        try {
            User newUser = buildUser(firstName, lastName, login, password, email, phone, passport);
            userDAO.addNewUser(newUser);
        } catch (Exception e) {
            //add a logger
        }
    }

    public User getUserByLogin(String login) { // add an Service Custom Exception
        User user = null;
        try {
            user = userDAO.getUserByLogin(login);
        } catch (Exception e) {
            // add a Logger
        }
        return user;
    }

    public User getUserById(int userId) {
        User user = null;
        try {
            user = userDAO.getUserById(userId);
        } catch (Exception e) {
            // add a Logger
        }
        return user;
    }

    public void deleteUser(int userId) {
        try {
            userDAO.delete(userId);
        } catch (Exception e) {
            // add a Logger
        }
    }

    public void blockUser(int userId) {
        try {
            userDAO.blockUser(userId);
        } catch (Exception e) {
            // add a Logger and a custom Exception
        }
    }

    public void unblockUser(int userId) {
        try {
            userDAO.unblockUser(userId);
        } catch (Exception e) {
            // add a logger and a custom Exception
        }
    }

    private User buildUser(String firstName, String lastName, String login,
                      String password, String email, String phone, String passport) {
        User user = new User();
        user.setUserRoleId(2);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassport(passport);
        user.setIsBlocked(false);
        return user;
    }
    public static void main(String[] args) {
        UserDAOMySql userDAOMySql = new UserDAOMySql();
        UserService userService = new UserService();
        User user = new User();
        userService.createUser("user2", "uziko", "hellich", "passik", "user2@gmail.com", "12345", "KC14555");
        System.out.println(user.toString());
    }
}
