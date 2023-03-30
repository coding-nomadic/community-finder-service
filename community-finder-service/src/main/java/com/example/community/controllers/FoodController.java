package com.example.community.controllers;

import com.example.community.models.FoodRequestDto;
import com.example.community.models.FoodResponseDto;
import com.example.community.services.FoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodResponseDto> createFood(@RequestBody FoodRequestDto foodRequestDto) {
        final FoodResponseDto foodResponseDto = foodService.createFoodRepo(foodRequestDto);
        return new ResponseEntity<>(foodResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FoodResponseDto>> getAllFood() {
        final List<FoodResponseDto> foodResponseDtos = foodService.getFoodies();
        return new ResponseEntity<>(foodResponseDtos, HttpStatus.OK);
    }
}
