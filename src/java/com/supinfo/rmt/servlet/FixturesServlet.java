/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.servlet;

import com.supinfo.rmt.model.Employee;
import com.supinfo.rmt.model.Manager;
import com.supinfo.rmt.model.User;
import com.supinfo.rmt.service.UserService;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lukas
 */
@WebServlet(urlPatterns="/fixtures")
public class FixturesServlet extends HttpServlet {
    
    @EJB
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Manager manager = new Manager();
        manager.setUsername("alick");
        manager.setPassword("pass");
        manager.setFirstname("Alick");
        manager.setLastname("Mouriesse");
        manager.setBirthDate(new Date(1970, 01, 01));
        userService.save(manager);
        
        Employee employee = new Employee();
        employee.setUsername("lukas");
        employee.setPassword("pass");
        employee.setFirstname("Lukas");
        employee.setLastname("Pili");
        employee.setBirthDate(new Date(1989, 07, 18));
        employee.setManager(manager);
        userService.save(employee);
        
    }
}
