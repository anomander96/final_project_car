package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.AccidentDAO;
import com.example.final_project_car.model.dao.impl.AccidentDAOMySql;
import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.model.exception.DAOException;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.builder.AccidentServiceBuilder;

import java.util.List;

public class AccidentService {
    private final AccidentDAO accidentDAO = AccidentDAOMySql.getInstance();
    private final AccidentServiceBuilder builder = new AccidentServiceBuilder();

    public List<Accident> getAllAccidents() throws ServiceException {
        List<Accident> accidents = null;
        try {
            accidents = accidentDAO.getAllAccidents();
        } catch (DAOException e) {
            throw new ServiceException(e);
        } return accidents;
    }

    public Accident getAccidentById(int accidentId) throws ServiceException {
        Accident accident = null;
        try {
            accident = accidentDAO.getAccidentById(accidentId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } return accident;
    }

    public void deleteAccident(int accidentId) throws ServiceException {
        try {
            accidentDAO.delete(accidentId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void createAccidentByAdmin(int accidentCategoryId, int orderId,
                                      String description, String costPerDamage) throws ServiceException {
        try {
            Accident accident = builder.build(accidentCategoryId, orderId, description, costPerDamage);
            accidentDAO.add(accident);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
