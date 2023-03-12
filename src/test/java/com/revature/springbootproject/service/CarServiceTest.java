package com.revature.springbootproject.service;

import com.revature.springbootproject.entity.Car;
import com.revature.springbootproject.repository.CarRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CarServiceTest {

    @MockBean(CarRepository.class)
    private CarRepository carRepository;
    @Autowired CarServiceImp carService;


        @Test
        public void testInsert() {
            Car car = new Car("Nissan","280Z","silver",1980,300,280);
            Car rcar = new Car((long)15,"Nissan","280Z","silver",1980,300,280,"");
            Mockito.when(carRepository.save(car)).thenReturn(rcar);
            Assert.assertEquals(rcar,carService.insert(car));
        }

        @Test
        public void testGetById() {
            Car car = new Car((long)15,"Nissan","280Z","silver",1980,300,280,"");
            Mockito.when(carRepository.findById((long)15)).thenReturn(Optional.of(car));
            Assert.assertEquals(car,carService.getById(15));
        }

        @Test
        public void testGetAll() {
            List<Car> cars = new ArrayList<Car>(){{
                add(new Car((long)15,"Nissan","280Z","silver",1980,300,280,""));
                add(new Car((long)16,"Dodge","Coronet","lime green",1970,426,425,""));
                add(new Car((long)17,"Buick","Grand National","black",1982,252,245,""));
            }};
            Mockito.when(carRepository.findAll()).thenReturn(cars);
            Assert.assertEquals(cars, carService.getAll());
        }

        @Test
        public void testUpdate() {
            Car car = new Car((long)15,"Nissan","280Z","silver",1980,300,280,"");
            Car ucar = new Car((long)15,"Nissan","280Z","blue",1980,300,280,"");
            car.setColor("blue");
            Mockito.when(carRepository.save(car)).thenReturn(ucar);
            Assert.assertEquals(ucar,carService.update(car));
        }

        @Test
        public void testDelete() {
            Mockito.when(carRepository.existsById((long)5)).thenReturn(true);
            Mockito.when(carRepository.existsById((long)9)).thenReturn(false);
            Assert.assertTrue(carService.delete((long)5));
            Assert.assertFalse(carService.delete((long)9));
        }
    };

