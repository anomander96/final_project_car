package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

public class Accident implements Serializable {
    private static final long serialVersionUID = 8449758699895284831L;
    private int accidentId;
    private int accidentCategoryId;
    private int orderId;
    private String description;
    private Timestamp accidentTime;
    private BigDecimal costPerDamage;

    public int getAccidentId() {
        return accidentId;
    }

    public void setAccidentId(int accidentId) {
        this.accidentId = accidentId;
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

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getAccidentTime() {
        return accidentTime;
    }

    public void setAccidentTime(Timestamp accidentTime) {
        this.accidentTime = accidentTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return accidentId == accident.accidentId &&
                accidentCategoryId == accident.accidentCategoryId &&
                orderId == accident.orderId &&
                Objects.equals(description, accident.description) &&
                Objects.equals(accidentTime, accident.accidentTime) &&
                Objects.equals(costPerDamage, accident.costPerDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accidentId, accidentCategoryId, orderId, description, accidentTime, costPerDamage);
    }

    @Override
    public String toString() {
        return "Accident{" +
                "accidentId=" + accidentId +
                ", accidentCategoryId=" + accidentCategoryId +
                ", orderId=" + orderId +
                ", description='" + description + '\'' +
                ", accidentTime=" + accidentTime +
                ", costPerDamage=" + costPerDamage +
                '}';
    }
}
