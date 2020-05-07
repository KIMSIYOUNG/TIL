package com.example.oauth2google;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;

@SpringBootTest
public class ApplicationTest {
    @BeforeEach
    public void setUp() {
        RestAssured.port = 8080;
    }

    @Test
    void index() {
        given()
            .when()
            .get("/")
            .then()
            .statusCode(200)
            .contentType("text/html")
            .body(containsString("권한 관리"));
    }
}
