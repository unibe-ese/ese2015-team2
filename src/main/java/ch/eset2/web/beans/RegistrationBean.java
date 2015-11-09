/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.model.dao.ProfileFacade;
import ch.eset2.web.util.Navigation;
import ch.eset2.web.util.ProfileFactory;
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
    
    @Inject
    private ProfileFacade profileFacade;

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
        Profile profile = ProfileFactory.getProfile(newCustomer.getAccountType());
        profile.setCustomer(newCustomer);
        newCustomer.setProfile(profile);
        customerFacade.create(newCustomer);
        profileFacade.create(profile);
        return Navigation.REGSUCCESS;
    }

    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }
    
}
