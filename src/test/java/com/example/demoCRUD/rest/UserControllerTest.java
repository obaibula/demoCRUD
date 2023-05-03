package com.example.demoCRUD.rest;


import com.example.demoCRUD.dto.UserDTOMapper;
import com.example.demoCRUD.entity.User;
import com.example.demoCRUD.entity.UserStatus;
import com.example.demoCRUD.service.UserService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void shouldSaveUser(){
        User user = new User(10, OffsetDateTime.now(), OffsetDateTime.now(),
                "vasya123", "my name is Vasya", "url.photo.jpg",
                "+38000000000", "vasya@gmail.com", "12345", UserStatus.online,
                Collections.emptyList());

        when(userService.save(user))
                .thenReturn(user);


        //todo: correct test...
        given().contentType(ContentType.JSON)
                .auth()
                .basic("susan", "123")
                .when()
                .post("/api/users/10")
                .then()
                .defaultParser(Parser.JSON)
                //.statusCode(HttpStatus.OK.value())
                .body("id", equalTo(3))
                .body("username", equalTo("vasya123"));


    }
}
















