package com.example.final_project_car.model.dao.builder;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.Accident;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class AccidentDAOBuilder {

    public Accident build(ResultSet resultSet) throws SQLException {
        int accidentId = resultSet.getInt(Parameters.ACCIDENT_ID);
        int accidentCategoryId = resultSet.getInt(Parameters.ACCIDENT_CATEGORY_ID);
        int orderId = resultSet.getInt(Parameters.ORDER_ID);
        Timestamp accidentTime = resultSet.getTimestamp(Parameters.ACCIDENT_TIME);
        String description = resultSet.getString(Parameters.DESCRIPTION);
        BigDecimal costPerDamage = resultSet.getBigDecimal(Parameters.COST_PER_DAMAGE);

        Accident accident = new Accident();
        accident.setAccidentId(accidentId);
        accident.setAccidentCategoryId(accidentCategoryId);
        accident.setOrderId(orderId);
        accident.setDescription(description);
        accident.setAccidentTime(accidentTime);
        accident.setCostPerDamage(costPerDamage);
        return accident;
    }
}
