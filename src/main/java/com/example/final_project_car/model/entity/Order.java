package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = -3376794396716197066L;
    private int orderId;
    private int userId;
    private int carId;
    private int orderStatusId;
    private boolean withDriver;
    private Timestamp createDate;
//    private Time rentDuration; // як варіант замінити на простий інт rentHours, тоді можна буде порахувати
    private int rentDuration;
    private BigDecimal totalPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public boolean getWithDriver() {
        return withDriver;
    }

    public void setWithDriver(boolean withDriver) {
        this.withDriver = withDriver;
    }

//    public Time getRentDuration() {
//        return rentDuration;
//    }

//    public void setRentDuration(Time rentDuration) {
//        this.rentDuration = rentDuration;
//    }


    public int getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && userId == order.userId && carId == order.carId && orderStatusId == order.orderStatusId && withDriver == order.withDriver && rentDuration == order.rentDuration && Objects.equals(createDate, order.createDate) && Objects.equals(totalPrice, order.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, carId, orderStatusId, withDriver, createDate, rentDuration, totalPrice);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", carId=" + carId +
                ", orderStatusId=" + orderStatusId +
                ", withDriver=" + withDriver +
                ", createDate=" + createDate +
                ", rentDuration=" + rentDuration +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
