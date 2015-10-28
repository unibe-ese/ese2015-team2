/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.testing;

import static ch.eset2.model.CourseProfile_.profile;
import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import static ch.eset2.model.Profile_.customer;
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
    }
}
