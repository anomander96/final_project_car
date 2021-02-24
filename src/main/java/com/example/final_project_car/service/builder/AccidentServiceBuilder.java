package com.example.final_project_car.service.builder;

import com.example.final_project_car.model.entity.Accident;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class AccidentServiceBuilder {

    public Accident build(int accidentCategoryId, int orderId, String description,
                          String costPerDamage) {
        Accident accident = new Accident();
        accident.setAccidentCategoryId(accidentCategoryId);
        accident.setOrderId(orderId);
        accident.setDescription(description);
        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        accident.setAccidentTime(timestamp);
        BigDecimal cost = new BigDecimal(costPerDamage);
        accident.setCostPerDamage(cost);
        return accident;
    }
}
