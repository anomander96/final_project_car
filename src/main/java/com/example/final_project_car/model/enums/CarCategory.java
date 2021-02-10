package com.example.final_project_car.model.enums;

import com.example.final_project_car.model.entity.Car;

public enum CarCategory {
    A,
    B,
    C,
    D,
    E;

    public static CarCategory getCarCategory(Car car) {
        int carCategoryId = car.getCarCategoryId();
        return CarCategory.values()[carCategoryId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
