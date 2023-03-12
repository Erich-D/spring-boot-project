package com.revature.springbootproject.service;

import com.revature.springbootproject.entity.Car;

import java.util.List;

public interface CarService {
    Car insert(Car car);
    Car getById(long id);
    List<Car> getAll();
    List<Car> getAll(String name);
    Car update(Car car);
    boolean delete(Long id);
}
