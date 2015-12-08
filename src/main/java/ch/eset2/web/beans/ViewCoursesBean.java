package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.Customer;
import ch.eset2.model.dao.CourseFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible for displaying all available courses
 * 
 * @author Marc Jost
 * @version 1.0
 */
@Named
@RequestScoped
public class ViewCoursesBean implements Serializable {

    private static final long serialVersionUID = -7474694757392637116L;
    
    @Inject
    private CourseFacade courseFacade;
    
    private List<Course> courses;
    
    @PostConstruct
    private void init(){
        courses = courseFacade.findAll();
    }
    
    public List<Course> getCourses(){
        return courses;
    }
    
    /**
     * Returns true if the currently logged in Customer has this course registered
     * in his profile.
     * 
     * @param c the course in question
     * @return true if the customer subscribed to this course, false otherwise
     */
    public boolean hasCourseRegistered(Course c){
        Customer customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        List<CourseProfile> cps = customer.getProfile().getCourseProfiles();
        for (CourseProfile cp : cps){
            if(cp.getCourse().equals(c)) return true;
        }
        return false;
    }
}
