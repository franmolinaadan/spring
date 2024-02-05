package com.severo.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "club")
public class Club {
    @Id
    @Column(name = "idclub")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,name = "foundation_date")
    private LocalDateTime foundationDate;
    @OneToMany
    private List<ClientHasClub> clientHasClub;
    @OneToMany
    private List<Event> event;
}
