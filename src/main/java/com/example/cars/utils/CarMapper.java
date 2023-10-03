package com.example.cars.utils;

import com.example.cars.dto.CarDto;
import com.example.cars.model.CarModel;

public class CarMapper {
    public static CarModel toCarModel(CarDto carDto){
        CarModel carModel = new CarModel();
        carModel.setBrand(carDto.getBrand());
        carModel.setModel(carModel.getModel());
        carModel.setColor(carDto.getColor());
        return carModel;
    }
    public static CarDto toCarDto(CarModel carModel){
        CarDto carDto = new CarDto();
        carDto.setBrand(carModel.getBrand());
        carDto.setModel(carModel.getModel());
        carDto.setColor(carModel.getColor());
        return carDto;
    }
}
