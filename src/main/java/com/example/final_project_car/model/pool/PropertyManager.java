package com.example.final_project_car.model.pool;

import java.util.ResourceBundle;

public final class PropertyManager {
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("db");

    public static String getProperty(String parameter) {
        return RESOURCE_BUNDLE.getString(parameter);
    }
}
