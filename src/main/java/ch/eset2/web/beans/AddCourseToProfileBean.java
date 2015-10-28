/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author foxhound
 */
@Named
@RequestScoped
public class AddCourseToProfileBean implements Serializable {
    
    private Profile profile;
    
    @Inject
    private ProfileFacade profileFacade;
    
    @Inject
    private CourseFacade courseFacade;
    
    @Inject
    private CourseProfileFacade courseProfileFacade;
    
    @PostConstruct
    private void init(){
        Customer customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        profile = customer.getProfile();
    }
    
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
