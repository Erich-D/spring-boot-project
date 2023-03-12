package com.revature.springbootproject.controller;

import com.revature.springbootproject.entity.Car;
import com.revature.springbootproject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping
    public Car insert(@RequestBody Car car){
        return carService.insert(car);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Car> getAll(@RequestParam(required = false, value = "make") String flag) {
        // if we don't pass in a request parameter flag, we should just get all pets
        System.out.println(flag);
        if(flag == null) return carService.getAll();
            // Otherwise, call the overloaded method:
        else return carService.getAll(flag);
    }

    @GetMapping("/{carIdentifier}")
    public Car getByIdOrName(@PathVariable("carIdentifier") Long identifier) {
        return carService.getById(identifier);
    }

    @PutMapping()
    public Car update(@RequestBody Car car) {
        return carService.update(car);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id) {
        return carService.delete(id);
    }
}
