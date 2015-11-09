/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import ch.eset2.model.Course;
import ch.eset2.model.CourseProfile;
import java.util.ArrayList;
import junit.framework.*;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Mischa Wenger
 */

public class CourseTest extends TestCase {

    Course course;
    CourseProfile cp;
             
   
   // assigning the values
   protected void setUp(){
      course = new Course();
      cp = new CourseProfile();
      course.testInit();
   }

   // test method to add two values
   public void testAddCourseProfile(){
       course.addCourseProfile(cp);
       assertEquals(cp, course.getCourseProfiles().get(0));
   }
   
   public void testRemoveCourseProfile(){
       ArrayList<CourseProfile> cpList = new ArrayList<>();
       cpList.add(cp);
       course.setCourseProfiles(cpList);
       
       course.removeCourseProfile(cp);
       assertTrue(course.getCourseProfiles().isEmpty());
       
   }
   
   public void testRemoveCourseProfile2(){
       ArrayList<CourseProfile> cpList = new ArrayList<>();
       CourseProfile cp2 = new CourseProfile();
       cp2.setId(11l);
       cpList.add(cp);
       cpList.add(cp2);
       
       course.setCourseProfiles(cpList);
       
       course.removeCourseProfile(cp);
       assertEquals(cp2, course.getCourseProfiles().get(0));
   }
}
