/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.Customer;
import ch.eset2.model.dao.CourseFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author foxhound
 */
@Named
@RequestScoped
public class ViewCoursesBean implements Serializable {
    
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
    
    public boolean hasCourseRegistered(Course c){
        Customer customer = (Customer) SecurityUtils.getSubject().getPrincipal();
        List<CourseProfile> cps = customer.getProfile().getCourseProfiles();
        for (CourseProfile cp : cps){
            if(cp.getCourse().equals(c)) return true;
        }
        return false;
    }
}
