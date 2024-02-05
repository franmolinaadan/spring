package com.severo.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "client_has_club")
public class ClientHasClub {

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "client_idclient")
    private Client client;

    @Id
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "club_idclub")
    private Club club;

    @Column(nullable = false,name = "is_leader")
    private String isLeader;

}
