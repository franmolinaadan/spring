package com.severo.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idevent")
    private Long id;
    @Column(nullable = false,name = "start_date")
    private LocalDateTime startDate;
    @Column(nullable = false,name = "start_ubi")
    private java.awt.Point startUbi;
    @Column(name = "end_ubi")
    private Point endUbi;
    private Long length;

    @ManyToOne
    @JoinColumn(name = "club_idclub")
    private Club club;
}
