package web.service;

import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars;

    public CarService() {
        // Инициализация списка из 5 машин в конструкторе
        cars = new ArrayList<>();
        cars.add(new Car("Toyota", "Camry", 2022));
        cars.add(new Car("Honda", "Accord", 2021));
        cars.add(new Car("BMW", "X5", 2023));
        cars.add(new Car("Mercedes", "C-Class", 2020));
        cars.add(new Car("Audi", "A4", 2022));
    }

    // Получить указанное количество машин из списка
    public List<Car> getCars(Integer count) {
        if (count == null || count >= cars.size()) {
            return new ArrayList<>(cars);
        }

        if (count <= 0) {
            return new ArrayList<>();
        }

        return new ArrayList<>(cars.subList(0, count));
    }

    // Получить все машины
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    // Получить общее количество машин
    public int getTotalCars() {
        return cars.size();
    }
}