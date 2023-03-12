package com.revature.springbootproject.service;

import com.revature.springbootproject.entity.Car;
import com.revature.springbootproject.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car insert(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getById(long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAll(String flag) {
        return carRepository.findByMake(flag);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public boolean delete(Long id) {
        boolean found = carRepository.existsById(id);
        if(found) carRepository.deleteById(id);
        return found;
    }
}
