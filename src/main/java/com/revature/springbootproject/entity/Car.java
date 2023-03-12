package com.revature.springbootproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String color;
    private int year;
    private int displacement;
    private int hp;
    private String imgUrl;

    public Car(String make,String model,String color,int year,int displacement,int hp){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.displacement = displacement;
        this.hp = hp;
    }
}
