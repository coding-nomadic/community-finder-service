package com.example.community.services;

import com.example.community.entities.Food;
import com.example.community.exceptions.CommunityException;
import com.example.community.exceptions.ResourceNotFoundException;
import com.example.community.models.FoodRequestDto;
import com.example.community.models.FoodResponseDto;
import com.example.community.repositories.FoodRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private ModelMapper modelMapper;

    /** create a food **/
    public FoodResponseDto createFoodRepo(FoodRequestDto foodRequestDto) {
        if (Boolean.TRUE.equals(foodRepository.existsByRestaurant(foodRequestDto.getRestaurant()))) {
            throw new CommunityException("Restaurant with same Name already exists!", "104");
        }
        final Food food = foodRepository.save(modelMapper.map(foodRequestDto, Food.class));
        return modelMapper.map(food, FoodResponseDto.class);
    }

    /** get all foods **/
    public List<FoodResponseDto> getFoodies() {
        List<Food> foods = foodRepository.findAll();
        if (!foods.isEmpty()) {
            return foods.stream().map(c -> modelMapper.map(c, FoodResponseDto.class)).toList();
        } else {
            throw new ResourceNotFoundException("Empty List from the Database", "102");
        }
    }
}
