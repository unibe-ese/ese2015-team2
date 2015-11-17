/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.dao.CourseFacade;
import ch.eset2.model.dao.CourseProfileFacade;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Responsible for searching and displaying tutors.
 * 
 * @author Marc Jost
 * @version 2.0
 */
@Named
@RequestScoped
public class SearchTutorsBean {
    
    private List<CourseProfile> courseProfiles;
    private List<CourseProfile> filteredCourseProfiles;
    private List<Course> availableCourses;
    
    @Inject
    private CourseFacade courseFacade;
    
    @Inject
    private CourseProfileFacade courseProfileFacade;
    
    @PostConstruct
    private void init(){
        courseProfiles = courseProfileFacade.findAllTutors();
        availableCourses = courseFacade.findAll();
    }
    
    public List<CourseProfile> getCourseProfiles(){
        return courseProfiles;
    }
    
    public List<CourseProfile> getFilteredCourseProfiles(){
        return filteredCourseProfiles;
    }
    
    public void setFilteredCourseProfiles(List<CourseProfile> filteredCourseProfiles){
        this.filteredCourseProfiles = filteredCourseProfiles;
    }
    
    public List<Course> getAvailableCourses(){
        return availableCourses;
    }
}