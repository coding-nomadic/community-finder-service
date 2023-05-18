package com.example.community.repositories;

import com.example.community.entities.Food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {

    /**
     * 
     * @param name
     * @return
     */
    Boolean existsByRestaurant(String name);
}
