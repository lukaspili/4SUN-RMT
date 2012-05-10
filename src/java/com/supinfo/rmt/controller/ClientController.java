/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controller;

import com.supinfo.rmt.model.Client;
import com.supinfo.rmt.model.Employee;
import com.supinfo.rmt.service.ClientService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

/**
 *
 * @author lukas
 */
@ManagedBean
public class ClientController {
    
    @EJB
    private ClientService clientService;
    
    private Client client;
    
    private List<SelectItem> selectItems;
    
    
    
    public String create() {
        clientService.save(client);
        return "manager_home?faces-redirect=true";
    }

    public Client getClient() {
        if(null == client) {
            client = new Client();
        }
        
        return client;
    }

    public List<SelectItem> getSelectItems() {
        if(null == selectItems) {
            selectItems = new ArrayList<SelectItem>();
            for(Client client : clientService.getAll()) {
                selectItems.add(new SelectItem(client, client.getName()));
            }
        }
        
        return selectItems;
    }
}
