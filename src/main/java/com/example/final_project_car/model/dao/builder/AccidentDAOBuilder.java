package com.example.final_project_car.model.dao.builder;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.Accident;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccidentDAOBuilder {

    public Accident build(ResultSet resultSet) throws SQLException {
        int accidentId = resultSet.getInt(Parameters.ACCIDENT_ID); // should check in work
        int accidentCategoryId = resultSet.getInt(Parameters.ACCIDENT_CATEGORY_ID); // should check in work
        int orderId = resultSet.getInt(Parameters.ORDER_ID); // should check in work
        Date accidentDate = resultSet.getDate(Parameters.ACCIDENT_DATE);
        String description = resultSet.getString(Parameters.DESCRIPTION);
        BigDecimal costPerDamage = resultSet.getBigDecimal(Parameters.COST_PER_DAMAGE);

        Accident accident = new Accident();
        accident.setAccidentId(accidentId);
        accident.setAccidentCategoryId(accidentCategoryId);
        accident.setOrderId(orderId);
        accident.setAccidentDate(accidentDate);
        accident.setDescription(description);
        accident.setCostPerDamage(costPerDamage);
        return accident;
    }
}
