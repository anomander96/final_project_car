package com.example.final_project_car.controller.validator;

import com.example.final_project_car.model.constants.Parameters;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final String LOGIN_PATTERN = "^[^\\s$/()]{3,25}$";
    private static final String NAME_PATTERN = "^[a-zA-Zа-яА-Я]{3,35}$";
    private static final String PASSWORD_PATTERN = "^[A-Za-z0-9!@#$%_&\\-*()<>]{6,16}$";
    private static final String EMAIL_PATTERN = "^[\\w\\d.]+@[a-zA-Z.]+\\.[A-Za-z]{1,4}$";
    private static final String PHONE_PATTERN = "^[\\d]{12}$";

    public static boolean validateLogin(String text) {
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateName(String text) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validatePassword(String text) {
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateEmail(String text) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validatePhone(String text) {
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static boolean validateUserData(Map<String, String> data) {
        return validateName(data.get(Parameters.FIRST_NAME)) &&
                validateName(data.get(Parameters.LAST_NAME)) &&
                validateLogin(data.get(Parameters.LOGIN)) &&
                validatePassword(data.get(Parameters.PASSWORD)) &&
                validateEmail(data.get(Parameters.EMAIL)) &&
                validatePhone(data.get(Parameters.PHONE));
    }

}
