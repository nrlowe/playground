package com.lowe.playground.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    class TestObject {
        int id, value;
        String name;
    }

    @PostMapping("/test")
    public ResponseEntity<String> testApiCall(@RequestBody TestObject testObject){
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleValidationException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
