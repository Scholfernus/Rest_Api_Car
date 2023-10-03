package com.example.cars.service;

import com.example.cars.dto.CarDto;
import com.example.cars.model.CarModel;
import com.example.cars.repository.CarRepository;
import com.example.cars.utils.CarMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public CarModel getCarById(Long id) {
    return carRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("cc"));
    }

    public List<CarModel> getCarList(){
        return carRepository.findAll();
    }

    public List<CarModel> getCarsByColor(String color) {
        return carRepository.listCarByColor(color);
    }

    public CarDto addCar(CarDto carDto) {
    CarModel carModel = CarMapper.toCarModel(carDto);
    CarModel addCar = carRepository.save(carModel);
    return CarMapper.toCarDto(addCar);
    }
}
