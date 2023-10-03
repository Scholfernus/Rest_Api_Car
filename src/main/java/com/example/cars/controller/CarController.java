package com.example.cars.controller;

import com.example.cars.dto.CarDto;
import com.example.cars.model.CarModel;
import com.example.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<CarModel>> getCarList() {
        try {
            List<CarModel> cars = carService.getCarList();
            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
//    @GetMapping("/{id}")
//    public  ResponseEntity<CarModel> getCarById(@PathVariable Long id){
//        return CarService.getCarById(id)
//                .map(CarModel-> ResponseEntity.ok(CarModel))
//                .orElse(ResponseEntity.notFound().build());
//
//    }
    @GetMapping("/{id}")
    public  ResponseEntity<CarModel> getCarById(@PathVariable Long id) {
        try {
            CarModel carModel = carService.getCarById(id);
            return ResponseEntity.ok(carModel);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/color/{color}")
    public ResponseEntity<List<CarModel>>getCarsByColor(@PathVariable String color){
        try{
            List<CarModel> cars = carService.getCarsByColor(color);
            return ResponseEntity.ok(cars);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto){
        try{
            CarDto addedCarDto = carService.addCar(carDto);
            return ResponseEntity.ok(addedCarDto);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
