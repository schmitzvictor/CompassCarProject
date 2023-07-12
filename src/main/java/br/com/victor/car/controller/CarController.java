package br.com.victor.car.controller;

import br.com.victor.car.entity.Car;
import br.com.victor.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarService carService;
    @GetMapping("/get")
    public String get(){
        return carService.getString();
    }

    @PostMapping("/post")
    public String post(@RequestBody Car car){
        return car.toString();
    }
}
