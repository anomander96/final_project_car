package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Accident;
import java.util.List;

public interface AccidentDAO {

    public List<Accident> getAllAccidents(); // Should write an own exception for DAO

    public Accident getAccidentById(int accidentId); // Should write an own exception for DAO

}
