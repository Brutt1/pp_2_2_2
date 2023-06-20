package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    private static List<Car> carList;
    static {
        carList = new ArrayList<>();
        carList.add(new Car("Land Rover", "Evoque", 190));
        carList.add( new Car("honda", "civic", 200));
        carList.add(new Car("bmw", "x6", 250));
        carList.add(new Car("LADA", "Granta", 0));
        carList.add(new Car("lada1", "KOPEIKA", 999));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarListOnCount(Integer countCars) {
        List<Car> list = getCars();
        if (countCars == null || countCars < 0 || countCars > list.size()) {
            countCars = list.size();
        }
        return list.stream().limit(countCars).toList();
    }
}