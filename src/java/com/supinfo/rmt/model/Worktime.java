/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author lukas
 */
@Entity
public class Worktime {
    
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    @ManyToOne @JoinColumn
    private Client client;
    
    @ManyToOne @JoinColumn
    private Employee employee;
    
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    
    @Temporal(TemporalType.DATE)
    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
