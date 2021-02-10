package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import java.sql.Date;
import java.util.Objects;

public class Accident implements Serializable {
    private static final long serialVersionUID = 8449758699895284831L;
    private int accidentId;
    private int accidentCategoryId;
    private int orderId;
    private Date accidentDate;
    private String description;
    private BigDecimal costPerDamage;

    public int getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(int id) {
        this.accidentId = id;
    }

    public int getAccidentCategoryId() {
        return accidentCategoryId;
    }

    public void setAccidentCategoryId(int accidentCategoryId) {
        this.accidentCategoryId = accidentCategoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int ordersId) {
        this.orderId = ordersId;
    }

    public Date getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(Date accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCostPerDamage() {
        return costPerDamage;
    }

    public void setCostPerDamage(BigDecimal costPerDamage) {
        this.costPerDamage = costPerDamage;
    }


    // варто подумати над сутністю accident_category, або додати поле в таблицю accident, або подумати інший спосіб


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return accidentId == accident.accidentId &&
                accidentCategoryId == accident.accidentCategoryId &&
                orderId == accident.orderId &&
                Objects.equals(accidentDate, accident.accidentDate) &&
                Objects.equals(description, accident.description) &&
                Objects.equals(costPerDamage, accident.costPerDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidentId, accidentCategoryId, orderId, accidentDate, description, costPerDamage);
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentId=" + accidentId +
                ", accidentCategoryId=" + accidentCategoryId +
                ", orderId=" + orderId +
                ", accidentDate=" + accidentDate +
                ", description='" + description + '\'' +
                ", costPerDamage=" + costPerDamage +
                '}';
    }
}
