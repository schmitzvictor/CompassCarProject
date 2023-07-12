package br.com.victor.car.service;

import br.com.victor.car.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    public String getString() {
        return "Dentro do Service";
    }
}
