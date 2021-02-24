package com.example.final_project_car.model.enums;

import com.example.final_project_car.model.entity.Accident;

public enum AccidentCategory {
    SINGLE_CAR_COLLISION,
    HEAD_ON_COLLISION,
    VEHICLE_ROLLOVER,
    MULTIPLE_VEHICLE_COLLISION,
    SIDESWIPE_COLLISION;

    public static AccidentCategory getAccidentCategory(Accident accident) {
        int accidentCategoryId = accident.getAccidentCategoryId();
        return AccidentCategory.values()[accidentCategoryId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
