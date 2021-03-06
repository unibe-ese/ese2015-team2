package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.web.util.InitialsGenerator;
import ch.eset2.web.util.PrivacyHelper;
import ch.eset2.web.util.ProfileStates;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible for displaying a profile.
 * The profile is being set by a viewparam in the URL
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Named
@ViewScoped
public class ViewProfileBean implements Serializable {

    private static final long serialVersionUID = 5176539471938649444L;
    
    @Inject
    private PrivacyHelper privacyHelper;
    
    private Customer viewedCustomer;
    private Customer loggedInCustomer;
    private Profile profile;
    
    private boolean hasCourses = false;
    private boolean myProfile = false;
    
    
    /**
     * Called on page load. 
     */
    public void init(){
        viewedCustomer = profile.getCustomer();
        hasCourses = !profile.getCourseProfiles().isEmpty();
        
        loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        if(loggedInCustomer == null) return; 
        myProfile = loggedInCustomer.getProfile().equals(profile);
    }
    
    public boolean hasPermissionToViewFullProfile(){
        return privacyHelper.hasPermissionToViewFullProfile(loggedInCustomer, viewedCustomer);
    }
    
    public boolean isActive(){
        return profile.getProfileState() == ProfileStates.ACTIVE;
    }
    
    public String getInitials(){
        if(profile != null){
            return InitialsGenerator.generateInitials(profile.getCustomer());
        } else {
            return ":(";
        }
    }

    // GETTERS AND SETTER
    public boolean isHasCourses() {
        return hasCourses;
    }
    
    public boolean isMyProfile(){
        return myProfile;
    }

    public Customer getViewedCustomer() {
        return viewedCustomer;
    }

    public void setViewedCustomer(Customer viewedCustomer) {
        this.viewedCustomer = viewedCustomer;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}