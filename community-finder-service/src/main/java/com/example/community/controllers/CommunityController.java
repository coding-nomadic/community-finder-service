package com.example.community.controllers;

import com.example.community.models.CommunityRequestDto;
import com.example.community.models.CommunityResponseDto;
import com.example.community.services.CommunityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    /**
     * 
     * @param communityRequestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<CommunityResponseDto> createCommunities(
                                    @RequestBody CommunityRequestDto communityRequestDto) {
        final CommunityResponseDto communityResponseDto = communityService.createCommunity(communityRequestDto);
        return new ResponseEntity<>(communityResponseDto, HttpStatus.CREATED);
    }

    /**
     * 
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<CommunityResponseDto> getCommunity(@PathVariable String id) {
        final CommunityResponseDto communityResponseDto = communityService.getCommunity(id);
        return new ResponseEntity<>(communityResponseDto, HttpStatus.OK);
    }

    /**
     * 
     * @return
     */
    @GetMapping
    public ResponseEntity<List<CommunityResponseDto>> getCommunities() {
        final List<CommunityResponseDto> communityResponseDto = communityService.getCommunities();
        return new ResponseEntity<>(communityResponseDto, HttpStatus.OK);
    }
}
