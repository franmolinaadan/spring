package com.severo.spring.repository;


import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Garage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BykeRepository extends JpaRepository<Byke, Long> {

}
