package br.com.victor.car.service;

import br.com.victor.car.entity.Car;
import br.com.victor.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;
    public String getString() {
        return "Dentro do Service";
    }

    public Car saveCar(Car car) {
        carRepository.save(car);
        return car;
    }

    public Car carFindById(Long idChassi) {
        Car car = carRepository.findByidChassi(idChassi);
        if (car == null){
            throw new IllegalArgumentException("car not found");
        }
        return car;
    }

}
