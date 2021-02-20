package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.User;
import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public User getUserById(int userId);

    public boolean delete(Integer userId);

    public User getUserByLogin(String login);

    public void registerUser(User user);

    public void blockUser(int userId);

    public void unblockUser(int userId);

    public void addNewUser(User user);

//    public void addAdmin(User user);
}
