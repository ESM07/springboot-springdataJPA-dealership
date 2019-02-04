package com.eduardo.cars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.cars.domain.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findByColor(String color);
	
	

}
