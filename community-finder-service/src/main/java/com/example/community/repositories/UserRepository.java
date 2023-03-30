package com.example.community.repositories;

import com.example.community.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * 
     * @param email
     * @return
     */
    Boolean existsByEmail(String email);
    
    /**
     * 
     * @param mobileNumber
     * @return
     */
    Boolean existsByMobileNumber(String mobileNumber);
}
