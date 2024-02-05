package com.severo.spring.repository;


import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Client;
import com.severo.spring.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GarageRepository extends JpaRepository<Garage, Long> {

}
