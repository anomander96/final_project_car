package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.UserDAO;
import com.example.final_project_car.model.dao.impl.UserDAOMySql;
import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.DAOException;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.builder.UserServiceBuilder;

import java.util.List;

public class UserService {
        private final UserDAO userDAO = UserDAOMySql.getInstance();

    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDAO.getAllUsers();
        } catch (DAOException e) {
            System.out.println(e.getMessage());
            throw new ServiceException(e);
        }
    }

    public User signIn(String login, String password) throws ServiceException {
        User user = null;

        // add a validation here
        //if (LoginPasswordValidator.validationLogin(login) && LoginPasswordValidator.validationPassword(password))

        try {
            user = userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        if (user.getLogin() != null && !user.getIsBlocked()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void createUser(String firstName, String lastName, String login,
                           String password, String email, String phone, String passport) throws ServiceException {

        // here we need to add a validators for login and password and passport mb

        try {
            UserServiceBuilder builder = new UserServiceBuilder();
            User newUser = builder.build(firstName, lastName, login, password, email, phone, passport);
            newUser.setUserRoleId(1);
            userDAO.addNewUser(newUser);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void createAdmin(String firstName, String lastName, String login,
                            String password, String email, String phone, String passport) throws ServiceException {
        try {
            UserServiceBuilder builder = new UserServiceBuilder();
            User newAdmin = builder.build(firstName, lastName, login, password, email, phone, passport);
            newAdmin.setUserRoleId(2);
            userDAO.addNewUser(newAdmin);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public User getUserByLogin(String login) throws ServiceException {
        User user;
        try {
            user = userDAO.getUserByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public User getUserById(int userId) throws ServiceException {
        User user;
        try {
            user = userDAO.getUserById(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }

    public void deleteUser(int userId) throws ServiceException {
        try {
            userDAO.delete(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void blockUser(int userId) throws ServiceException {
        try {
            userDAO.blockUser(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void unblockUser(int userId) throws ServiceException {
        try {
            userDAO.unblockUser(userId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
