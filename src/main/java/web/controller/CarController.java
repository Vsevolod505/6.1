package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class CarController {
    private final CarServiceImpl carServiceImpl;

    @Autowired
    public CarController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        System.out.println(count);
        List<Car> cars= carServiceImpl.getCarList(count);
        System.out.println("Cars list size in controller: " + cars.size());
        model.addAttribute("cars", cars);
        System.out.println(cars);
        return "cars";
    }
}