package com.example.community.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodResponseDto {

    private Long id;

    private String restaurant;

    private String address;

    private String mobileNumber;

    private String geoLocation;

}
