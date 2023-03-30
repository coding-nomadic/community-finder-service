package com.example.community.models;

import lombok.Data;

@Data
public class CommunityRequestDto {
    
    private Long id;
    private String name;
    private String geoLocation;
}
