package ch.eset2.testing;

import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import ch.eset2.model.Customer;
import ch.eset2.model.dao.CourseFacade;
import ch.eset2.model.dao.CourseProfileFacade;
import ch.eset2.model.dao.CustomerFacade;
import ch.eset2.model.dao.ProfileFacade;
import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data links between courses and customers
 * in the database.
 *
 * @author Mischa Wenger
 * @version 2.0
 */
@Singleton
@Startup
@DependsOn("DevelopmentDataCourses")
public class DevelopementDataCourseToProfile {

    @Inject
    private CustomerFacade customerFacade;
    
    @Inject
    private CourseFacade courseFacade;
    
    @Inject
    private ProfileFacade profileFacade;
    
    @Inject
    private CourseProfileFacade courseProfileFacade;

    public DevelopementDataCourseToProfile() {

    }

    @PostConstruct
    public void initializeTestData() {
        addTestCoursesToProfiles();
    }

    private void addTestCoursesToProfiles() {
        try {
            Course course = courseFacade.findAll().get(0);
            Course course2 = courseFacade.findAll().get(1);
            
            Customer mischa = customerFacade.findCustomerByUsername("mischa.wenger").get(0);
            Customer eve = customerFacade.findCustomerByUsername("eve.mendoza").get(0);
            Customer ese = customerFacade.findCustomerByUsername("ese").get(0);
            Customer ese2 = customerFacade.findCustomerByUsername("ese2").get(0);
            
            CourseProfile courseProfile = new CourseProfile();
            courseProfile.setCourse(course);
            courseProfile.setFee("20.00");
            courseProfile.setGrade(5);
            courseProfile.setPassedInYear("2014");
            courseProfile.setProfile(ese.getProfile());
            ese.getProfile().addCourseProfile(courseProfile);
            courseProfileFacade.create(courseProfile);
            profileFacade.edit(ese.getProfile());
            course.addCourseProfile(courseProfile);
            courseFacade.edit(course);
            
            CourseProfile courseProfile2 = new CourseProfile();
            courseProfile2.setCourse(course);
            courseProfile2.setProfile(ese2.getProfile());
            ese2.getProfile().addCourseProfile(courseProfile2);
            courseProfileFacade.create(courseProfile2);
            course.addCourseProfile(courseProfile2);
            courseFacade.edit(course);
            
        } catch (Exception e) {
            // do nothing
        }
    }
}