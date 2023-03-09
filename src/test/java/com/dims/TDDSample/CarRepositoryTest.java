package com.dims.TDDSample;

import com.dims.TDDSample.domain.Car;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

//@RunWith(SpringRunner.class)
//@DataJpaTest
//Won't pass because they skipped all the implementation details and lost me
public class CarRepositoryTest {

    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCar_returnsCarDetails() throws Exception {
        // Use your entity manager to save the data to the database instead of using the regular repository.save() as this will flush your save to the database while the regular repository.save() will only save to cache instead
        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));
        Car car = repository.findByName("prius");

        assertThat(car.getName()).isEqualTo(savedCar.getName());
        assertThat(car.getType()).isEqualTo(savedCar.getType());
    }

}