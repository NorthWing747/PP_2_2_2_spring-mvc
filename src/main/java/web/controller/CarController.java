package web.controller;

import web.model.Car;
import web.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam(required = false) Integer count, Model model) {
        List<Car> cars;

        if (count != null) {
            cars = carService.getCars(count);
        } else {
            cars = carService.getAllCars();
        }

        model.addAttribute("cars", cars);
        model.addAttribute("totalCars", carService.getTotalCars());
        model.addAttribute("requestedCount", count);

        return "cars";
    }
}

//http://localhost:8080/cars - все 5 машин
//http://localhost:8080/cars?count=2 - первые 2 машины
//http://localhost:8080/cars?count=3 - первые 3 машины
//http://localhost:8080/cars?count=5 - все 5 машин
//http://localhost:8080/cars?count=10 - все 5 машин (так как всего 5)
//http://localhost:8080/cars?count=0 - пустой список