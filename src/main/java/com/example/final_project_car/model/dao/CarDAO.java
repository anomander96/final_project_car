package com.example.final_project_car.model.dao;

import com.example.final_project_car.model.entity.Car;
import java.util.List;

public interface CarDAO {

    public List<Car> getAllCars(); // Should write an own exception for DAO

    public Car getCarById(int carId); // Should write an own exception for DAO

    public boolean delete(Integer carId);

    public boolean update(Car car);

    public void addNewCar(Car car);


    // pagination methods
    public List<Car> findCars(int currentPage, int numberOfRecords);
    public Integer getNumberOfRows();




    //public boolean add(Car car); //

    // should think how to do a filter by brand name

    // should think how to do a filter by car category

    // should think how to do a filter by rental price

}
