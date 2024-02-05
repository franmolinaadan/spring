package com.severo.spring.repository;


import com.severo.spring.entity.Byke;
import com.severo.spring.entity.Client;
import com.severo.spring.entity.Club;
import com.severo.spring.entity.Garage;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface ClientRepository extends JpaRepository<Client, Long>,CustomClientRepoI {
    @Query(value = "SELECT * FROM client WHERE username LIKE %:username%",nativeQuery = true)
    Client searchByUsername(String username);
    @Query("SELECT c FROM Client c WHERE c.gender = 'Male'")
    List<Client> encontrarClientesHombre();
    /**@Query("SELECT c FROM Club c JOIN ClientHasClub h ON c.clientHasClub.club = h.club JOIN Client c ON h.client.id = c.id WHERE c.id = :clientId")
    Club encontrarClubPorCliente(Long clientId);*/
    @Query("SELECT g FROM Garage g JOIN Client c ON g.client.id = c.id WHERE c.id = :clientId")
    Garage encontrarGaragePorCliente(Long clientId);
    @Query("SELECT b FROM Byke b JOIN Garage g ON b.garage.id = g.id JOIN Client c ON g.client.id = c.id WHERE c.id = :clientId")
    List<Byke> encontrarMotoPorCliente(Long clientId);
    @Query("SELECT COUNT(b) FROM Byke b JOIN Garage g ON b.garage.id = g.id JOIN Client c ON g.client.id = c.id WHERE c.id = :clientId")
    int cantidadMotosCliente(Long clientId);
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ClientHasClub c WHERE c.client.id = :clientId")
    boolean existsByClientId(Long clientId);
    @Query("SELECT c FROM Client c WHERE YEAR(c.birthDate) = :year")
    List<Client> findByBirthYear(int year);

}
