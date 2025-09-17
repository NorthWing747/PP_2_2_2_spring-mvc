package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDao {
    private final List<Car> cars = Arrays.asList(
            new Car("Toyota", "Camry", 2022),
            new Car("Honda", "Accord", 2021),
            new Car("BMW", "X5", 2023),
            new Car("Mercedes", "C-Class", 2020),
            new Car("Audi", "A4", 2022)
    );

    public List<Car> getCars(int count) {
        if (count <= 0) {
            return Collections.emptyList();
        }
        return cars.stream()
                .limit(count)
                .collect(Collectors.toList());
    }
}
