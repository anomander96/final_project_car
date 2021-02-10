package com.example.final_project_car.model.enums;

import com.example.final_project_car.model.entity.Accident;

public enum AccidentCategory {
    LOW,
    MEDIUM,
    HIGH;

    public static AccidentCategory getAccidentCategory(Accident accident) {
        int accidentCategoryId = accident.getAccidentCategoryId();
        return AccidentCategory.values()[accidentCategoryId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
