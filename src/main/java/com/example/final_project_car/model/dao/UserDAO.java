package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.User;
import com.example.final_project_car.model.exception.DAOException;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers() throws DAOException;

    public User getUserById(int userId) throws DAOException;

    public boolean delete(Integer userId) throws DAOException;

    public User getUserByLogin(String login) throws DAOException;

    public void registerUser(User user) throws DAOException;

    public void blockUser(int userId) throws DAOException;

    public void unblockUser(int userId) throws DAOException;

    public void addNewUser(User user) throws DAOException;
}
