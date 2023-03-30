package com.example.community.repositories;

import com.example.community.entities.Community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {

    /**
     * 
     * @param name
     * @return
     */
    Boolean existsByName(String name);
}
