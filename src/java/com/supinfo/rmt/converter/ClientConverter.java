/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.converter;

import com.supinfo.rmt.model.Client;
import com.supinfo.rmt.service.ClientService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author lukas
 */
@ManagedBean
public class ClientConverter implements Converter {
    
    @EJB
    private ClientService clientService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return clientService.findById(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return String.valueOf(((Client) value).getId());
    } 
}