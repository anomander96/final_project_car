package com.example.final_project_car.service.builder;

import com.example.final_project_car.model.entity.User;

public class UserServiceBuilder {

    public User build(String firstName, String lastName, String login,
                      String password, String email, String phone, String passport) {
        User user = new User();
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
}
