package com.example.final_project_car.model.dao.builder;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOBuilder {

    public User build(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt(Parameters.USER_ID);
        int userRoleId = resultSet.getInt(Parameters.USER_ROLE_ID); // should check in work
        String firstName = resultSet.getString(Parameters.FIRST_NAME);
        String lastName = resultSet.getString(Parameters.LAST_NAME);
        String login = resultSet.getString(Parameters.LOGIN);
        String password = resultSet.getString(Parameters.PASSWORD);
        String email = resultSet.getString(Parameters.EMAIL);
        String phone = resultSet.getString(Parameters.PHONE);
        String passport = resultSet.getString(Parameters.PASSPORT);
        boolean isBlocked = resultSet.getBoolean(Parameters.IS_BLOCKED);

        User user = new User();
        user.setUserId(userId);
        user.setUserRoleId(userRoleId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassport(passport);
        user.setIsBlocked(isBlocked);
        return user;
    }
}
