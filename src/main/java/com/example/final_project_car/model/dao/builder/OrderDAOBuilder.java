package com.example.final_project_car.model.dao.builder;

import com.example.final_project_car.model.constants.Parameters;
import com.example.final_project_car.model.entity.Order;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDAOBuilder {

    public Order build(ResultSet resultSet) throws SQLException {
        int orderId = resultSet.getInt(Parameters.ORDER_ID);
        int userId = resultSet.getInt(Parameters.USER_ID); // should check in work
        int carId = resultSet.getInt(Parameters.CAR_ID); // should check in work
        int orderStatusId = resultSet.getInt(Parameters.ORDER_STATUS_ID); // should check in work
//        Date createDate = resultSet.getDate(Parameters.CREATE_DATE);
        boolean withDriver = resultSet.getBoolean(Parameters.WITH_DRIVER);
//        Time rentDuration = resultSet.getTime(Parameters.RENT_DURATION);
        int rentHours = resultSet.getInt(Parameters.RENT_HOURS);
        BigDecimal totalPrice = resultSet.getBigDecimal(Parameters.TOTAL_PRICE); // should calculate this parameter in DB

        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setCarId(carId);
        order.setOrderStatusId(orderStatusId);
//        order.setCreateDate(createDate);
        order.setWithDriver(withDriver);
//        order.setRentDuration(rentDuration);
        order.setRentDuration(rentHours);
        order.setTotalPrice(totalPrice);
        return order;
    }
}
