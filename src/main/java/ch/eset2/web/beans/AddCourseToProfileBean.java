package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.Customer;
import ch.eset2.model.Profile;
import ch.eset2.model.dao.CourseFacade;
import ch.eset2.model.dao.CourseProfileFacade;
import ch.eset2.model.dao.ProfileFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible for making the connection between Profile and Course,
 * respresented by a CourseProfile entry.
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Named
@RequestScoped
public class AddCourseToProfileBean implements Serializable {

    private static final long serialVersionUID = -352365355798420073L;
    
    private Profile profile;
    
    @Inject
    private ProfileFacade profileFacade;
    
    @Inject
    private CourseFacade courseFacade;
    
    @Inject
    private CourseProfileFacade courseProfileFacade;
    
    @PostConstruct
    public void init(){
        Customer customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        profile = customer.getProfile();
    }
    
    
    /**
     * adds a course to the profile of the current customer.
     * The course should not be null
     * @param course to be added to the profile of the customer
     */
    public void addCourse(Course course){
        CourseProfile cp = new CourseProfile();
        
        profile.addCourseProfile(cp);
        course.addCourseProfile(cp);
        
        cp.setProfile(profile);
        cp.setCourse(course);
        courseProfileFacade.create(cp);
        profileFacade.edit(profile);
        courseFacade.edit(course);
    }
}
