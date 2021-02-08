package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = -3376794396716197066L;
    private int id;
    private int userId;
    private int carId;
    private int orderStatusId;
    private LocalDateTime createDate;
    private boolean withDriver;
    private Time rentDuration;
    private BigDecimal totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public boolean getWithDriver() {
        return withDriver;
    }

    public void setWithDriver(boolean withDriver) {
        this.withDriver = withDriver;
    }

    public Time getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(Time rentDuration) {
        this.rentDuration = rentDuration;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    // варто подумати над сутністю order_status, або додати поле в таблицю orders, або подумати інший спосіб
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id &&
                userId == order.userId &&
                carId == order.carId &&
                orderStatusId == order.orderStatusId &&
                withDriver == order.withDriver &&
                Objects.equals(createDate, order.createDate) &&
                Objects.equals(rentDuration, order.rentDuration) &&
                Objects.equals(totalPrice, order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, carId, orderStatusId, createDate, withDriver, rentDuration, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", carId=" + carId +
                ", orderStatusId=" + orderStatusId +
                ", createDate=" + createDate +
                ", withDriver=" + withDriver +
                ", rentDuration=" + rentDuration +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
