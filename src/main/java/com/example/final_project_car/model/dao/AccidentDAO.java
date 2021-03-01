package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Accident;
import com.example.final_project_car.model.entity.Order;
import com.example.final_project_car.model.exception.DAOException;

import java.util.List;

public interface AccidentDAO {

    public List<Accident> getAllAccidents() throws DAOException;

    public Accident getAccidentById(int accidentId) throws DAOException;

    public List<Accident> getAccidentsByOrderId(int orderId) throws DAOException;

    public boolean delete(Integer accidentId) throws DAOException;

    public void add(Accident accident) throws DAOException;




}
