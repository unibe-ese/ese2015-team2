/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.testing;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Profile;
import ch.eset2.model.StudentProfile;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.model.dao.ProfileFacade;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 *
 * @author foxhound
 */
@Singleton
@Startup
public class DevelopmentDataUsers {

    @Inject
    private CustomerFacade customerFacade;
    
    @Inject
    private ProfileFacade profileFacade;

    public DevelopmentDataUsers() {

    }

    @PostConstruct
    public void initializeTestData() {
        createTestUsers();
    }

    private void createTestUsers() {
        
        
        Customer customer = new Customer();
        customer.setAccountType(1);
        customer.setCity("Bern");
        customer.setFirstName("Marc");
        customer.setLastName("Jost");
        customer.setMatnr("12-108-130");
        customer.setPassword("123");
        customer.setPhone("");
        customer.setStreet("Stöckackerstrasse 98");
        customer.setUsername("marc.jost");
        customer.setZip("3018");
        
        Profile profile = new StudentProfile();
        profile.setCustomer(customer);
        customer.setProfile(profile);
        customerFacade.create(customer);
        profileFacade.create(profile);
        
        
        Customer customer2 = new Customer();
        customer2.setAccountType(1);
        customer2.setCity("Thun");
        customer2.setFirstName("Mischa");
        customer2.setLastName("Wenger");
        customer2.setMatnr("11-109-089");
        customer2.setPassword("123");
        customer2.setPhone("");
        customer2.setStreet("Weidenweg 10D");
        customer2.setUsername("mischa.wenger");
        customer2.setZip("3608");
        
        Profile profile2 = new StudentProfile();
        profile2.setCustomer(customer2);
        customer2.setProfile(profile2);
        customerFacade.create(customer2);
        profileFacade.create(profile2);
        
        
    }
}
