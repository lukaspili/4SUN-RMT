/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.rmt.controller;

import com.supinfo.rmt.model.Employee;
import com.supinfo.rmt.model.Manager;
import com.supinfo.rmt.service.EmployeeService;
import com.supinfo.rmt.service.UserService;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author lukas
 */
@ManagedBean
public class EmployeeController {
    
    @EJB
    private EmployeeService employeeService;
    
    @ManagedProperty("#{userController}")
    private UserController userController;
    
    private Employee employee = new Employee();
    
    private DataModel<Employee> dataModel;
    
    public String create() {
        
        employee.setManager((Manager) userController.getLoggedUser());
        
        if(null == employeeService.save(employee)) {
            return null;
        }
        
        return "manager_home?faces-redirect=true";
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public DataModel<Employee> getDataModel() {
        if(null == dataModel) {
            List<Employee> employees = employeeService.getEmployeesByManager(
                    (Manager) userController.getLoggedUser());
            System.out.println("Employees : " + employees.size());
            dataModel = new ListDataModel<Employee>(employees);
        }
        
        return dataModel;
    }

    public void setUserController(UserController userController) {
        this.userController = userController;
    }
}
