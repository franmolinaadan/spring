package com.severo.spring.service;

import com.severo.spring.entity.Byke;
import com.severo.spring.repository.BykeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BykeService {
    private final BykeRepository bykeRepository;

    public BykeService(BykeRepository bykeRepository){
        this.bykeRepository=bykeRepository;
    }

    public List<Byke> getAll(){
        return bykeRepository.findAll();
    }
    public Byke getById(Long id){
        Optional<Byke> optional= bykeRepository.findById(id);
        return optional.orElse(null);
    }
    public Byke create(Byke byke){
        bykeRepository.save(byke);
        return byke;
    }
}
