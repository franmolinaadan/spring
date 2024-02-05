package com.severo.spring.repository;


import com.severo.spring.entity.Client;
import com.severo.spring.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long>,CustomClubRepoI {
    @Query(value = "SELECT * FROM club WHERE name LIKE %:name%",nativeQuery = true)
    List<Club> searchByName(String name);
}
