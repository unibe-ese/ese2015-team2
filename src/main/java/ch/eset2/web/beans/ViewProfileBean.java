package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.web.util.InitialsGenerator;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible for displaying a profile.
 * The profile is being set by a viewparam in the URL
 * @author Marc Jost
 */
@Named
@ViewScoped
public class ViewProfileBean implements Serializable {
    
    private Customer customer;
    private Profile profile;
    
    private boolean hasCourses = false;
    private boolean myProfile = false;
    
    /**
     * Called on page load. 
     */
    public void init(){
        customer = profile.getCustomer();
        hasCourses = !profile.getCourseProfiles().isEmpty();
        
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        if(loggedInCustomer == null) return; 
        myProfile = loggedInCustomer.getProfile().equals(profile);
    }
    
    public String getInitials(){
        return InitialsGenerator.generateInitials(profile.getCustomer());
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
