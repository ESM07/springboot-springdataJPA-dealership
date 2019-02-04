package com.eduardo.cars.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.cars.domain.Car;
import com.eduardo.cars.repository.CarRepository;

@RestController
@RequestMapping(value = "/dealership")
public class CarController {

	private CarRepository carRepository;

	@Autowired
	protected CarController(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}
	//Read
	@GetMapping(value = "/cars")
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}
	//Create
	@PostMapping(value = "/cars")
	public void insertCar(@RequestBody Car car) {
		carRepository.save(car);

	}
	
	@PutMapping(value = "/cars/{id}")
	public void updateCar(@PathVariable Integer id, @RequestBody Car car) {
		if(carRepository.existsById(id))
			carRepository.save(car);
	}
	
	//Delete
	@DeleteMapping(value = "/cars/{id}")
	public void deleteCar(@PathVariable Integer id) {
		carRepository.deleteById(id);
	}
	
	//Filter
	@GetMapping(value = "/cars/{id}")
	public Optional<Car> findById(@PathVariable Integer id) {
		return carRepository.findById(id);
			
	}
	
	@GetMapping(value = "/cars/{color}")
	public List<Car> findByColor(@PathVariable String color) {
		return carRepository.findByColor(color);

	}

}
