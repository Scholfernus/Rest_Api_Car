package com.example.cars.repository;

import com.example.cars.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<CarModel, Long> {
    List<CarModel> findByColor(String color);
    @Query("SELECT c FROM CarModel c WHERE c.color = :color")
    List<CarModel> listCarByColor(@Param("color") String color);
}
