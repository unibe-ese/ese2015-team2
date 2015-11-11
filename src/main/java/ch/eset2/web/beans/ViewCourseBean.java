/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author foxhound
 */

@Named
@ViewScoped
public class ViewCourseBean implements Serializable {
    
    private Course course;
    private List<CourseProfile> courseProfiles = new ArrayList<CourseProfile>();
    
    public void init(){
        for(CourseProfile cp : course.getCourseProfiles()){
            if(isTutorProfile(cp)) courseProfiles.add(cp);
        }
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
    
    private boolean isTutorProfile(CourseProfile cp){
        return cp.getProfile().getCustomer().getAccountType() == AccountType.TUTOR;
    }
}