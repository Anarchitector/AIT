package repository;

import domain.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarRepositoryMap implements CarRepository {

    private Map<Long, Car> database = new HashMap<>();
    private long currentId;


    @Override
    public Car save(Car car) {
        car.setId(++currentId);
        database.put(currentId, car);
        return car;
    }

    @Override
    public Car getById(Long id) {
        return database.get(id);
    }

    @Override
    public List<Car> getAll() {
        return List.of();
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
