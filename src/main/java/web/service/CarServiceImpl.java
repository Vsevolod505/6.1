package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    List<Car> cars = new ArrayList<>();

    public CarServiceImpl() {
        cars.add(new Car("BMV", "M8", 2022));
        cars.add(new Car("Lexus", "LX570", 2018));
        cars.add(new Car("RAM", "2500", 2020));
        cars.add(new Car("Porsche", "Cayenne Coupe", 2023));
        cars.add(new Car("Subaru", "Impreza WRX STI", 2000));
        System.out.println("CarServiceImpl constructor called, cars list size: " + cars.size());
    }

    @Override
    public List<Car> getCarList(Optional<Integer> count) {
        return count.map(integer -> cars.stream().limit(integer).toList()).orElse(cars);
    }
}
