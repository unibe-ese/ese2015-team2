/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author foxhound
 */
@Named
@RequestScoped
public class ViewProfileBean {
    
    private Customer customer;
    private Profile profile;
    
    @PostConstruct
    private void init(){
        // Only works for my profile for now
        customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        profile = customer.getProfile();
    }
    
    public boolean belongsToMe(){
        // return (SecurityUtils.... get...profile.id == parameter dann true 
        return true;
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
