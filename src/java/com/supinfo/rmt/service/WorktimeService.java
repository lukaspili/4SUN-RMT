/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.service;

import com.supinfo.rmt.model.Employee;
import com.supinfo.rmt.model.Worktime;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lukas
 */
@Stateless
public class WorktimeService {
    
    @PersistenceContext
    private EntityManager em;
    
    public Worktime save(Worktime worktime) {
        em.persist(worktime);
        return worktime;
    }
    
    public List<Worktime> getWorktimesByEmployee(Employee employee) {
        return em.createQuery("SELECT w FROM Worktime w WHERE w.employee=:employee")
                .setParameter("employee", employee)
                .getResultList();
    }

    public void remove(Worktime worktime) {
        em.remove(em.merge(worktime));
    }
    
}
