package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.web.util.AccountType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Responsible for viewing a single course
 * 
 * @author Marc Jost
 * @version 1.0
 */

@Named
@ViewScoped
public class ViewCourseBean implements Serializable {

    private static final long serialVersionUID = 6719395635620760732L;
    
    private Course course;
    private List<CourseProfile> courseProfiles = new ArrayList<CourseProfile>();
    
    /**
     * Initializes the list shown on the web page, which shows
     * all available tutors of this course. 
     */
    public void init(){
        for(CourseProfile cp : course.getCourseProfiles()){
            if(isTutorProfile(cp)) courseProfiles.add(cp);
        }
    }
    
    /**
     * Checks if the provided CourseProfile is associated to a tutor.
     * 
     * @param cp the courseprofile in question
     * @return true if the profile related to this CourseProfile belongs to a 
     *  Tutor, false otherise.
     */
    private boolean isTutorProfile(CourseProfile cp){
        return cp.getProfile().getCustomer().getAccountType() == AccountType.TUTOR;
    }

    public List<CourseProfile> getCourseProfiles(){
        return courseProfiles;
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}