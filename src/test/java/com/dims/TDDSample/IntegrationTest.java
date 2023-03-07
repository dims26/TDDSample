package com.dims.TDDSample;

import com.dims.TDDSample.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)//Because it is an integration test. Run server on a random port
public class IntegrationTest {

    @Autowired
    //Provide by Spring. Use this to make test REST requests to your server.
    //Allows you to add basic headers to rest request, useful for authentication and stuff
    private TestRestTemplate restTemplate;

    @Test
    public void getCar_returnsCarDetails() throws Exception{
        //arrange

        //act
        //Calling this endpoint should return a car. That's the purpose of this integration test
        ResponseEntity<Car> response = restTemplate.getForEntity("cars/prius", Car.class);

        //assert
        //Assertj library was recommended over junit assertion library
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("prius");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }
}
