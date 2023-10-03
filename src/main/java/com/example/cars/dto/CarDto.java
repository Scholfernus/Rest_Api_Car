package com.example.cars.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class CarDto {

    private String brand;
    private String model;
    private String color;
}
