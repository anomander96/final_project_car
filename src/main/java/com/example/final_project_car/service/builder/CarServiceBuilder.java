package com.example.final_project_car.service.builder;

import com.example.final_project_car.model.entity.Car;
import java.math.BigDecimal;

public class CarServiceBuilder {

    public Car build(String carCategoryId, String brandName, String modelName, String color, double price) {
        Car car = new Car();
        car.setCarCategoryId(Integer.parseInt(carCategoryId));
        car.setBrandName(brandName);
        car.setModelName(modelName);
        car.setColor(color);
        car.setPrice(BigDecimal.valueOf(price));
        return car;
    }
}
