package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.CarDAO;
import com.example.final_project_car.model.dao.impl.CarDAOMySql;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.service.builder.CarServiceBuilder;

import java.math.BigDecimal;
import java.util.List;

public class CarService {
    private final CarDAO carDao = CarDAOMySql.getInstance();

    //0.+++ public List<Car> getAllCars(); --> invoke from DAO
    //1.+++ public Car getCarById(); --> invoke from DAO
    //2.+++ public boolean deleteCar(); --> invoke from DAO
    //3. public void addCar(); --> invoke from DAO

    public List<Car> getAllCars() throws Exception { // add an own signature
        //List<Car> carsContainer
        try {
            return carDao.getAllCars();
        } catch (Exception e) {
            // add a Logger and a custom Exception
            throw new Exception(e);
        }
    }

    public Car getCarById(int carId) {
        Car car = null;
        try {
            car = carDao.getCarById(carId);
        } catch (Exception e) {
            // add a Logger and a custom exception
        } return car;
    }

    public boolean deleteCar(int carId) {
        try {
            carDao.delete(carId);
            return true;
        } catch (Exception e) {
            // add a logger and a custom exception
        } return false;
    }

    public void createCar(String carCategoryId, String brandName, String modelName,
                          String color, double price) {
        try {
            CarServiceBuilder builder = new CarServiceBuilder();
            Car newCar = builder.build(carCategoryId, brandName, modelName, color, price);
            carDao.addNewCar(newCar);
        } catch (Exception e) {
            // add a Logger here and a custom exception
        }
    }

    // should fix this, doesn't work correctly
    public void updateCar(Car car) {
        try {
            carDao.update(car);
        } catch (Exception e) {
            // add a Logger and a custom exception
        }
    }

    public List<Car> findCarsForPagination(int currentPage, int numberOfRecords) {
        List<Car> cars = null;
        try {
            cars = carDao.findCars(currentPage, numberOfRecords);
        } catch (Exception e) {
            // add a Logger and a custom exception
        } return cars;
    }

    public Integer getNumberOfRows() {
        Integer numberOfRows = 0;
        try {
            numberOfRows = carDao.getNumberOfRows();
        } catch (Exception e) {
            // add a Logger and a custom Exception
        } return numberOfRows;
    }

//    public static void main(String[] args) {
//
//        //carService.createCar("1", "Volvo", "XS90", "white", 90);
////        CarServiceBuilder builder = new CarServiceBuilder();
////        Car car = builder.build("1", "Volvo", "CSI", "black", 22);
////        CarService carService = new CarService();
////        carService.updateCar(car);
//        CarService carService = new CarService();
//        CarServiceBuilder builder = new CarServiceBuilder();
//        //Car car = builder.build("1", "Lada", "Samara", "gray", 13);
//        carService.createCar("1", "Tesla", "Model X", "white", 27);
//    }
}
