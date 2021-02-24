package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.exception.DAOException;
import java.util.List;

public interface CarDAO {

    public List<Car> getAllCars() throws DAOException;

    public Car getCarById(int carId) throws DAOException;

    public boolean delete(Integer carId) throws DAOException;

    public void update(Car car) throws DAOException;

    public void addNewCar(Car car) throws DAOException;


    // pagination methods
    public List<Car> findCars(int currentPage, int numberOfRecords) throws DAOException;
    public Integer getNumberOfRows() throws DAOException;
}
