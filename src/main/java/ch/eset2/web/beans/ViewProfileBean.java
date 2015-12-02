package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.web.util.InitialsGenerator;
import ch.eset2.web.util.PrivacyHelper;
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
    
    @Inject
    private PrivacyHelper privacyHelper;
    
    @Inject
    private AddFriendBean addFriendBean;
    
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
    
    // TODO: Remove this. Adding friends directly won't be possible
    public void addFriend(){
        addFriendBean.addFriend(loggedInCustomer, viewedCustomer);
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
