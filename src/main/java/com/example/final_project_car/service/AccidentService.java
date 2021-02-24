package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.AccidentDAO;
import com.example.final_project_car.model.dao.impl.AccidentDAOMySql;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.service.builder.AccidentServiceBuilder;

import java.util.List;

public class AccidentService {
    private final AccidentDAO accidentDAO = AccidentDAOMySql.getInstance();
    private final AccidentServiceBuilder builder = new AccidentServiceBuilder();

    public List<Accident> getAllAccidents() {
        List<Accident> accidents = null;
        try {
            accidents = accidentDAO.getAllAccidents();
        } catch (Exception e) {
            // add a custom Exception and a Logger
        } return accidents;
    }

    public Accident getAccidentById(int accidentId) {
        Accident accident = null;
        try {
            accident = accidentDAO.getAccidentById(accidentId);
        } catch (Exception e) {
            // add a custom Exception and a logger
        } return accident;
    }

    public void deleteAccident(int accidentId) {
        try {
            accidentDAO.delete(accidentId);
        } catch (Exception e) {
            // add a custom Exception and a Logger
        }
    }

    public void createAccidentByAdmin(int accidentCategoryId, int orderId,
                                      String description, String costPerDamage) {
        try {
            Accident accident = builder.build(accidentCategoryId, orderId, description, costPerDamage);
            accidentDAO.add(accident);
        } catch (Exception e) {
            // add a logger and a custom exception
        }
    }

    public static void main(String[] args) {
        AccidentService service = new AccidentService();
        service.createAccidentByAdmin(2, 2, "single-car-collision", "449");

    }
}
