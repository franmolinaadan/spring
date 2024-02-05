package com.severo.spring.repository;

import com.severo.spring.entity.Client;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

public class CustomClientRepository implements CustomClientRepoI{
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void deleteByUsername(String username){
        CriteriaBuilder builder= em.getCriteriaBuilder();
        CriteriaQuery<Client> criteriaQuery=builder.createQuery(Client.class);
        Root<Client> root=criteriaQuery.from(Client.class);
        criteriaQuery.where(builder.like(root.get("username"),
                "%"+username+"%"));
        Client client=em.createQuery(criteriaQuery).setMaxResults(1).getSingleResult();
        System.out.println(client);
        em.remove(client);
    }
}
