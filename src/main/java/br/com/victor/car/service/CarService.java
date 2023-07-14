package br.com.victor.car.service;

import br.com.victor.car.dto.CarDTO;
import br.com.victor.car.entity.Car;
import br.com.victor.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car saveCar(CarDTO carDTO) {
        String brand = carDTO.getBrand();
        if (!isValidBrand(brand)) {
            throw new IllegalArgumentException("Invalid brand");
        }

        Car car = new Car();
        car.setName(carDTO.getName());
        car.setBrand(brand);
        car.setColor(carDTO.getColor());
        car.setFabricationYear(carDTO.getFabricationYear());

        if (hasNullValues(car)) {
            throw new IllegalArgumentException("Null values are not allowed");
        }

        return carRepository.save(car);
    }

    public Car getCarByChassi(Long idChassi) {
        return carRepository.findById(idChassi)
                .orElseThrow(() -> new IllegalArgumentException("Car not found"));
    }

    private boolean isValidBrand(String brand) {
        return brand.equals("Ford") || brand.equals("Chevrolet") ||
                brand.equals("BMW") || brand.equals("Volvo");
    }

    private boolean hasNullValues(Car car) {
        return  car.getName() == null ||
                car.getBrand() == null || car.getColor() == null ||
                car.getFabricationYear() == null;
    }
}
