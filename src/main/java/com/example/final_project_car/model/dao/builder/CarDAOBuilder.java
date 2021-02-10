package com.example.final_project_car.model.dao.builder;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.Car;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDAOBuilder {

    public Car build(ResultSet resultSet) throws SQLException {
        int carId = resultSet.getInt(Parameters.CAR_ID);
        int carCategoryId = resultSet.getInt(Parameters.CAR_CATEGORY_ID); // should check in work
        String brandName = resultSet.getString(Parameters.BRAND_NAME);
        String modelName = resultSet.getString(Parameters.MODEL_NAME);
        String color = resultSet.getString(Parameters.COLOR);
        BigDecimal price = resultSet.getBigDecimal(Parameters.PRICE);

        Car car = new Car();
        car.setCarId(carId);
        car.setCarCategoryId(carCategoryId);
        car.setBrandName(brandName);
        car.setModelName(modelName);
        car.setColor(color);
        car.setPrice(price);
        return car;
    }
}
