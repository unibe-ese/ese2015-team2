/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Marc Jost
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean implements Serializable {
    
    @Inject
    private CustomerFacade customerFacade;

    private Customer newCustomer;
    
    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationBean() {
    }
    
    @PostConstruct
    private void init(){
        newCustomer = new Customer();
    }
    
    public String registerNewCustomer(){
        customerFacade.create(newCustomer);
        return Navigation.REGSUCCESS;
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }
}
