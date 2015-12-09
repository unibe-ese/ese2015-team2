package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.web.util.Navigation;
import ch.eset2.web.util.ProfileFactory;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * Responsible for registering new customers 
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Named(value = "registrationBean")
@RequestScoped
public class RegistrationBean implements Serializable {

    private static final long serialVersionUID = 1324596504093015041L;
    
    @Inject
    private CustomerFacade customerFacade;
    
    private Customer newCustomer;
    
    @PostConstruct
    private void init(){
        newCustomer = new Customer();
    }
    
    /**
     * Saves the new customer to the database and creates an empty profile.
     * @return the RegistrationSuccess page.
     */
    public String registerNewCustomer(){
        Profile profile = ProfileFactory.getProfile(newCustomer.getAccountType());
        profile.setCustomer(newCustomer);
        newCustomer.setProfile(profile);
        newCustomer.setPassword(new Sha256Hash(newCustomer.getPassword()).toHex());
        customerFacade.create(newCustomer);
        
        return Navigation.REGSUCCESS;
    }

    
    //getters and setters
    public Customer getNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }
}