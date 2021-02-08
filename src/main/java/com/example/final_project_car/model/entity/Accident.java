package com.example.final_project_car.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Accident implements Serializable {
    private static final long serialVersionUID = 8449758699895284831L;
    private int id;
    private int ordersId;
    private LocalDateTime date;
    private String description;
    private BigDecimal costPerDamage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id &&
                ordersId == accident.ordersId &&
                Objects.equals(date, accident.date) &&
                Objects.equals(description, accident.description) &&
                Objects.equals(costPerDamage, accident.costPerDamage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordersId, date, description, costPerDamage);
    }

    @Override
    public String toString() {
        return "Accident{" +
                "id=" + id +
                ", ordersId=" + ordersId +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", costPerDamage=" + costPerDamage +
                '}';
//        StringBuilder sb = new StringBuilder("Accident{");
//        sb.append("id=").append(id).
//                append(", ordersId=").append(ordersId).
//                append(", date=").append(date).
//                append(System.lineSeparator()).
//                append(", description=").append(description).
//                append(System.lineSeparator()).
//                append(", costPerDamage").append(costPerDamage).
//                append('}');
//        return sb.toString();
    }
}
