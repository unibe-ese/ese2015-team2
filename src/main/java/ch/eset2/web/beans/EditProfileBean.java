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
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author foxhound
 */
@Named
@ViewScoped
public class EditProfileBean implements Serializable {
    
    // TODO: make it so that a user cannot change an other users profile
    
    @Inject
    private ProfileFacade profileFacade;
    
    @Inject
    private CustomerFacade customerFacade;

    private Profile profile;
    private Customer customer;
    
    public EditProfileBean(){
        
    }
    
    @PostConstruct
    private void retrieveCustomer(){
        customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        if(customer.getProfile()==null){
            profile = ProfileFactory.getProfile(customer.getAccountType());
            profile.setCustomer(customer);
            profileFacade.create(profile);
            customer.setProfile(profile);
            customerFacade.edit(customer);
        }
        
    }
    
    public String saveProfile(){
        try {
            profileFacade.edit(profile);
            customerFacade.edit(customer);
            return Navigation.INDEX;
        } catch (Exception e){ // TODO
            System.out.println("ch.eset2.web.beans.EditProfileBean.saveProfile()");
            e.printStackTrace();
            return null;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    
}
