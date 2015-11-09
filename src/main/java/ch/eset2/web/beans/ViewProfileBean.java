/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.CourseProfile;
import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author foxhound
 */
@Named
@ViewScoped
public class ViewProfileBean implements Serializable {
    
    private Customer customer;
    private Profile profile;
    
    private boolean hasCourses = false;
    private boolean myProfile = false;
    
    public void init(){
        customer = profile.getCustomer();
        hasCourses = !profile.getCourseProfiles().isEmpty();
        
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        myProfile = loggedInCustomer.getProfile().equals(profile);
    }

    public boolean isHasCourses() {
        return hasCourses;
    }
    
    public boolean isMyProfile(){
        return myProfile;
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
