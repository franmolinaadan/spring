package com.severo.spring.service;

import com.severo.spring.entity.Client;
import com.severo.spring.entity.Club;
import com.severo.spring.repository.ClientRepository;
import com.severo.spring.repository.ClubRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ClubService {
    private final ClubRepository clubRepository;

    public ClubService(ClubRepository clubRepository){
        this.clubRepository=clubRepository;
    }

    public List<Club> getAll(){
        return clubRepository.findAll();
    }
    public Club getById(Long id){
        Optional<Club> optional= clubRepository.findById(id);
        return optional.orElse(null);
    }
    public List<Club> searchByName(String name){
        return clubRepository.searchByName(name);
    }
}
