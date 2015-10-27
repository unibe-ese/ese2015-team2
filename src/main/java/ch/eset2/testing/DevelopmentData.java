/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.testing;

import ch.eset2.model.Customer;
import ch.eset2.model.dao.CustomerFacade;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 * @author foxhound
 */
@Singleton
@Startup
public class DevelopmentData {
    
    @Inject
    private CustomerFacade customerFacade;
    
    public DevelopmentData(){
        
    }
    
    @PostConstruct
    private void initializeTestData(){
        Customer customer = new Customer();
        customer.setAccountType(1);
        customer.setCity("3018");
        customer.setFirstName("Marc");
        customer.setLastName("Jost");
        customer.setMatnr("12-108-130");
        customer.setPassword("123");
        customer.setPhone("");
        customer.setStreet("Stöckackerstrasse 98");
        customer.setUsername("marc.jost");
        customer.setZip("3018");
        customerFacade.create(customer);
    }
}
