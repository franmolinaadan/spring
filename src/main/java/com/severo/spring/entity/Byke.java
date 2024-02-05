package com.severo.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Blob;
import java.time.LocalDateTime;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "byke")
public class Byke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbyke")
    private Long id;
    private String brand;
    private String model;
    private LocalDateTime fecha;
    //private Blob image;
    @ManyToOne
    @JoinColumn(name = "garage_idgarage")
    private Garage garage;
}
