package com.example.community.services;

import com.example.community.entities.User;
import com.example.community.exceptions.CommunityException;
import com.example.community.models.UserRequestDto;
import com.example.community.models.UserResponseDto;
import com.example.community.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    /** saves new user in DB **/
    public UserResponseDto saveUser(UserRequestDto userRequestDto) {
        if (Boolean.TRUE.equals(userRepository.existsByEmail(userRequestDto.getEmail()))) {
            throw new CommunityException("Email already exists!", "104");
        }
        if (Boolean.TRUE.equals(userRepository.existsByMobileNumber(userRequestDto.getMobileNumber()))) {
            throw new CommunityException("Mobile Number already exists!", "104");
        }
        User user = userRepository.save(mapper.map(userRequestDto, User.class));
        return mapper.map(user, UserResponseDto.class);
    }
}
