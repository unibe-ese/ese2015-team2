package ch.eset2.testing;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Profile;
import ch.eset2.model.StudentProfile;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.model.dao.ProfileFacade;
import ch.eset2.web.util.AccountType;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 *
 * @author Marc Jost
 * @version 1.0
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
        customer.setAccountType(AccountType.TUTOR);
        customer.setCity("Bern");
        customer.setFirstName("Marc");
        customer.setLastName("Jost");
        customer.setMatnr("12-108-130");
        customer.setPassword("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
        customer.setPhone("");
        customer.setStreet("Stöckackerstrasse 98");
        customer.setUsername("marc.jost");
        customer.setZip("3018");
        
        Profile profile = new StudentProfile();
        profile.setCustomer(customer);
        profile.setImageLink("http://bigpicturesb.net/wp-content/uploads/2011/11/generic-profile-pic.png");
        customer.setProfile(profile);
        customerFacade.create(customer);
        profileFacade.create(profile);
        
        
        Customer customer2 = new Customer();
        customer2.setAccountType(AccountType.TUTOR);
        customer2.setCity("Thun");
        customer2.setFirstName("Mischa");
        customer2.setLastName("Wenger");
        customer2.setMatnr("11-109-089");
        customer2.setPassword("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
        customer2.setPhone("");
        customer2.setStreet("Weidenweg 10D");
        customer2.setUsername("mischa.wenger");
        customer2.setZip("3608");
        
        Profile profile2 = new StudentProfile();
        profile2.setCustomer(customer2);
        customer2.setProfile(profile2);
        customerFacade.create(customer2);
        profileFacade.create(profile2);
        
        
        Customer customer3 = new Customer();
        customer3.setAccountType(AccountType.STUDENT);
        customer3.setCity("Zürich");
        customer3.setFirstName("Eve");
        customer3.setLastName("Mendoza");
        customer3.setMatnr("11-100-089");
        customer3.setPassword("a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3");
        customer3.setPhone("");
        customer3.setStreet("Gesellschaftsstrasse 3");
        customer3.setUsername("eve.mendoza");
        customer3.setZip("8100");
        
        Profile profile3 = new StudentProfile();
        profile3.setCustomer(customer3);
        customer3.setProfile(profile3);
        customerFacade.create(customer3);
        profileFacade.create(profile3);
        
    }
}
