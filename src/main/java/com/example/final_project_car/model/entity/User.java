package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 8897246935493420277L;
    private int userId;
    private int userRoleId;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private String phone;
    private String passport;
    private boolean isBlocked;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        if (userId < 0) {
            userId = 0;
        }
        this.userId = userId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    // варто подумати над сутністю user_role, або додати поле в таблицю user, або подумати інший спосіб

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                userRoleId == user.userRoleId &&
                isBlocked == user.isBlocked &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userRoleId, firstName,
                lastName, login, password, email, phone, passport, isBlocked);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userRoleId=" + userRoleId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", passport='" + passport + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
