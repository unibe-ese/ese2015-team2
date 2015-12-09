package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.model.dao.CourseFacade;
import ch.eset2.model.dao.CourseProfileFacade;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.model.dao.ProfileFacade;
import ch.eset2.web.util.InitialsGenerator;
import ch.eset2.web.util.Navigation;
import ch.eset2.web.util.ProfileStates;
import ch.eset2.web.util.UserHelper;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;

/**
 * EditeProfileBean manages changes of the profile.
 * It allows to persist edited profile variables to the database.
 * {@link EditProfileBean#retrieveCustomer() } should be called from the server before
 * using any service of this class.
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Named
@ViewScoped
public class EditProfileBean implements Serializable {

    private static final long serialVersionUID = -8552658775341071415L;

    @Inject
    private ProfileFacade profileFacade;

    @Inject
    private CustomerFacade customerFacade;
    
    @Inject
    private CourseProfileFacade courseProfileFacade;
    
    @Inject
    private CourseFacade courseFacade;
    
    @Inject
    private UserHelper userHelper;
    
    private Profile profile;
    private Customer customer;
    
    // Used to store the new password entered by the user
    private String newPassword = "";

    public EditProfileBean() {

    }

    /**
     * Finds and loads customer of active session. 
     * Loads the profile of the customer.
     */
    @PostConstruct
    private void retrieveCustomer() {
        customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        if (customer.getProfile() == null) return;
        profile = customer.getProfile();
    }
    
    /**
     * Generates the Initials uses for the profile picture (if no pic is present)
     * @return String representation of a customer's initials. E.g Marc Jost
     *          returns MJ
     */
    public String getInitials(){
        return InitialsGenerator.generateInitials(customer);
    }

    /**
     * Persists the profileChanges to the database.
     * @return redirect to viewprofile page
     */
    public String saveProfile() {
        try {
            profileFacade.edit(profile);
            if(!newPassword.isEmpty()) customer.setPassword(new Sha256Hash(newPassword).toHex());
            customerFacade.edit(customer);
            return Navigation.VIEWPROFILE + "?faces-redirect=true&id=" + userHelper.getMyProfileID();
        } catch (RuntimeException e){
            throw e; // Jenkins suggestion
        } catch (Exception e) { // TODO
            // do nothing
            return Navigation.INDEX;
        }
    }
    
    /**
     * Removes a courseProfile from this customer's profile, from the course
     * and from the join table CourseProfile
     * @param cp 
     */
    public void removeCourseProfile(CourseProfile cp){
        Course course = cp.getCourse();
        course.getCourseProfiles().remove(cp);
        courseFacade.edit(course);
        profile.getCourseProfiles().remove(cp);
        profileFacade.edit(profile);
        courseProfileFacade.remove(cp);
    }
    
    /**
     * Deactivates the profile of the logged in customer
     * 
     * @return the Index page when deleted successfully.
     */
    public String removeProfile() {
        profile.setProfileState(ProfileStates.INACTIVE);
        profileFacade.edit(profile);
        return Navigation.INDEX;
    }

    // GETTERS AND SETTER
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
    
    public String getNewPassword(){
        return newPassword;
    }
    
    public void setNewPassword(String newPassword){
        this.newPassword = newPassword;
    }
}