package com.example.community.controllers;

import com.example.community.models.FoodRequestDto;
import com.example.community.models.FoodResponseDto;
import com.example.community.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodResponseDto> createFood(@RequestBody FoodRequestDto foodRequestDto) {
        return new ResponseEntity<>(foodService.createFoodRepo(foodRequestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAllFood() {
        return new ResponseEntity<>(foodService.getFoodies(), HttpStatus.OK);
    }
}
