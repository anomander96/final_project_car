package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Car implements Serializable {
    private static final long serialVersionUID = 8872568352484813771L;
    private int carId;
    private int carCategoryId;
    private String brandName;
    private String modelName;
    private String color;
    private BigDecimal price;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int id) {
        this.carId = id;
    }

    public int getCarCategoryId() {
        return carCategoryId;
    }

    public void setCarCategoryId(int carCategoryId) {
        this.carCategoryId = carCategoryId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // варто подумати над сутністю car_category, або додати поле в таблицю car, або подумати інший спосіб

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId &&
                carCategoryId == car.carCategoryId &&
                Objects.equals(brandName, car.brandName) &&
                Objects.equals(modelName, car.modelName) &&
                Objects.equals(color, car.color) &&
                Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, carCategoryId, brandName, modelName, color, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carCategoryId=" + carCategoryId +
                ", brandName='" + brandName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
