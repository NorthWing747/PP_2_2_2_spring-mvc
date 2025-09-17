package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.DAO.CarDao;
import web.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private final CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public List<Car> getCars(Integer count) {
        List<Car> cars = carDao.getCars();

        if (count == null || count <= 0) {
            return new ArrayList<>();
        }

        return cars.stream()
                .limit(count)
                .toList();
    }
}