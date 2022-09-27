package com.lottyx.lottyxbackend;

import com.lottyx.lottyxbackend.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Sql("/test.sql")
    public void findUserByIdTest(){
        ResponseEntity<User> response = testRestTemplate.getForEntity("/api/v1/user/1005", User.class);

        Assertions.assertEquals(1005, response.getBody().getId());
        Assertions.assertEquals("John", response.getBody().getName());
        Assertions.assertEquals("Doe", response.getBody().getSurname());
        Assertions.assertEquals("john@doe.com", response.getBody().getEmail());
        Assertions.assertEquals("qwerty", response.getBody().getPassword());
    }

}
