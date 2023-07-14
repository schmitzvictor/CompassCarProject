package br.com.victor.car.controller;

import br.com.victor.car.dto.CarDTO;
import br.com.victor.car.entity.Car;
import br.com.victor.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/get/{idChassi}")
    public ResponseEntity<Car> FindByidChassi(@PathVariable("idChassi") Long idChassi){
        Car entity = carService.getCarByChassi(idChassi);
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/post")
    public Car post(@RequestBody CarDTO car){
        return carService.saveCar(car);
    }
}
