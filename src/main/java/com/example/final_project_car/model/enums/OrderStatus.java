package com.example.final_project_car.model.enums;

import com.example.final_project_car.model.entity.Order;

public enum OrderStatus {
    OPENED,
    CONFIRMED,
    PAID,
    CLOSED;

    public static OrderStatus getOrderStatus(Order order) {
        int orderStatusId = order.getOrderStatusId();
        return OrderStatus.values()[orderStatusId];
    }

    public String getName() {
        return name().toLowerCase();
    }
}
