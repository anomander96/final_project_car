package com.example.final_project_car.model.dao.builder;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.Order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class OrderDAOBuilder {

    public Order build(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt(Parameters.ORDER_ID);
        int userId = resultSet.getInt(Parameters.USER_ID);
        int carId = resultSet.getInt(Parameters.CAR_ID);
        int orderStatusId = resultSet.getInt(Parameters.ORDER_STATUS_ID);
        boolean withDriver = resultSet.getBoolean(Parameters.WITH_DRIVER);
        Timestamp createDate = resultSet.getTimestamp(Parameters.CREATE_DATE);
        int rentDuration = resultSet.getInt(Parameters.RENT_DURATION);
        BigDecimal totalPrice = resultSet.getBigDecimal(Parameters.TOTAL_PRICE);

        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setCarId(carId);
        order.setOrderStatusId(orderStatusId);
        order.setWithDriver(withDriver);
        order.setCreateDate(createDate);
        order.setRentDuration(rentDuration);
        order.setTotalPrice(totalPrice);
        return order;
    }
}
