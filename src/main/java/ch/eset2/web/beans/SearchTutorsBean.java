package ch.eset2.web.beans;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.dao.CourseProfileFacade;
import java.io.Serializable;
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
public class SearchTutorsBean implements Serializable {

    private static final long serialVersionUID = -1293941133096182060L;
    
    private List<CourseProfile> courseProfiles;
    private List<CourseProfile> filteredCourseProfiles;
    
    @Inject
    private CourseProfileFacade courseProfileFacade;
    
    @PostConstruct
    private void init(){
        courseProfiles = courseProfileFacade.findAllTutors();
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
}