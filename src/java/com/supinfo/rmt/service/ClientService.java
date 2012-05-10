/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.service;

import com.supinfo.rmt.model.Client;
import com.supinfo.rmt.model.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lukas
 */
@Stateless
public class ClientService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Client save(Client client) {
        em.persist(client);
        return client;
    }
    
    public List<Client> getAll() {
        return em.createQuery("SELECT c FROM Client c").getResultList();
    }

    public Object findById(long id) {
        return em.find(Client.class, id);
    }
}
