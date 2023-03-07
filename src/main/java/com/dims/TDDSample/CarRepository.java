package com.dims.TDDSample;

import com.dims.TDDSample.domain.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Car findByName(String name);
}
