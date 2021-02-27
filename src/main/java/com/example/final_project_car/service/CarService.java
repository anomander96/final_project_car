package com.example.final_project_car.service;

import com.example.final_project_car.model.dao.CarDAO;
import com.example.final_project_car.model.dao.impl.CarDAOMySql;
import com.example.final_project_car.model.entity.Car;
import com.example.final_project_car.model.exception.DAOException;
import com.example.final_project_car.model.exception.ServiceException;
import com.example.final_project_car.service.builder.CarServiceBuilder;

import java.util.List;

public class CarService {
    private final CarDAO carDao = CarDAOMySql.getInstance();

    public List<Car> getAllCars() throws ServiceException {
        try {
            return carDao.getAllCars();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Car getCarById(int carId) throws ServiceException {
        Car car = null;
        try {
            car = carDao.getCarById(carId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } return car;
    }

    public void deleteCar(int carId) throws ServiceException {
        try {
            carDao.delete(carId);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void createCar(String carCategoryId, String brandName, String modelName,
                          String color, double price) throws ServiceException {
        try {
            CarServiceBuilder builder = new CarServiceBuilder();
            Car newCar = builder.build(carCategoryId, brandName, modelName, color, price);
            carDao.addNewCar(newCar);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public void updateCar(Car car) throws ServiceException {
        try {
            carDao.update(car);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public List<Car> findCarsForPagination(int currentPage, int numberOfRecords) throws ServiceException {
        List<Car> cars = null;
        try {
            cars = carDao.findCars(currentPage, numberOfRecords);
        } catch (DAOException e) {
            throw new ServiceException(e);
        } return cars;
    }

    public Integer getNumberOfRows() throws ServiceException {
        Integer numberOfRows = 0;
        try {
            numberOfRows = carDao.getNumberOfRows();
        } catch (DAOException e) {
            throw new ServiceException(e);
        } return numberOfRows;
    }
}
