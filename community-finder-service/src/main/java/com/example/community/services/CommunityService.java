package com.example.community.services;

import com.example.community.entities.Community;
import com.example.community.exceptions.CommunityException;
import com.example.community.exceptions.ResourceNotFoundException;
import com.example.community.models.CommunityRequestDto;
import com.example.community.models.CommunityResponseDto;
import com.example.community.repositories.CommunityRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private ModelMapper mapper;

    /** create a community **/
    public CommunityResponseDto createCommunity(CommunityRequestDto communityRequestDto) {
        if (Boolean.TRUE.equals(communityRepository.existsByName(communityRequestDto.getName()))) {
            throw new CommunityException("Community with same Name already exists!", "104");
        }
        Community community = communityRepository.save(mapper.map(communityRequestDto, Community.class));
        return mapper.map(community, CommunityResponseDto.class);
    }

    /** get all community by id **/
    public CommunityResponseDto getCommunity(String id) {
        final Optional<Community> community = communityRepository.findById(Long.valueOf(id));
        if (community.isPresent()) {
            return mapper.map(community.get(), CommunityResponseDto.class);
        } else {
            throw new ResourceNotFoundException("Community not found with this id : " + id, "102");
        }
    }

    /** get all communities **/
    public List<CommunityResponseDto> getCommunities() {
        List<Community> community = communityRepository.findAll();
        if (!community.isEmpty()) {
            return community.stream().map(c -> mapper.map(c, CommunityResponseDto.class)).toList();
        } else {
            throw new ResourceNotFoundException("Empty List from the Database", "102");
        }
    }
}
