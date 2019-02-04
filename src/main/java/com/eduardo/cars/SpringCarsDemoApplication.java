package com.eduardo.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.eduardo.cars.domain.Car;
import com.eduardo.cars.repository.CarRepository;

@SpringBootApplication
public class SpringCarsDemoApplication implements ApplicationRunner{
	
	@Autowired
	CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCarsDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		carRepository.save(new Car("Honda", "Accord", "Black", 10000.0));
		carRepository.save(new Car("Honda", "Civic", "Green", 5000.0));
		carRepository.save(new Car("Toyota", "Corolla", "White", 6000.0));
		carRepository.save(new Car("Ford", "F-150", "Gray", 11000.0));
	}
}
