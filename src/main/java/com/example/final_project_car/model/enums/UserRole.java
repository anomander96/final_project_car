package com.example.final_project_car.model.enums;

import com.example.final_project_car.model.entity.User;

public enum UserRole {
    CLIENT,
    ADMIN;

    public static UserRole getUserRole(User user) {
        int userRoleId = user.getUserRoleId();
        return UserRole.values()[userRoleId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
