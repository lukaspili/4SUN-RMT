/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.service;

import com.supinfo.rmt.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lukas
 */
@Stateless
public class UserService {
    
    @PersistenceContext
    private EntityManager em;
    
    public User save(User user) {
        
        try {
            User existingUser = (User) em.createQuery("SELECT u from User u WHERE u.username=:username")
                .setParameter("username", user.getUsername())
                .getSingleResult();
            
            return null; // Username already exists
            
        } catch(NoResultException e) {
            // OK
        }
        
        em.persist(user);
        return user;
    }
    
    public User login(String username, String password){
        
        try {
            return (User) em.createQuery("SELECT u FROM User u "
                    + "WHERE u.username=:username AND u.password=:password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch(NoResultException e) {
            return null; // user n'existe pas
        }
    }
}
