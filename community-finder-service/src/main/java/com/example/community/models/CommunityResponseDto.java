package com.example.community.models;

import lombok.Data;

@Data
public class CommunityResponseDto {
    private Long id;
    private String name;
    private String geoLocation;
}
