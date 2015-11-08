/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import ch.eset2.model.CourseProfile;
import ch.eset2.model.Profile;
import ch.eset2.model.StudentProfile;
import java.util.ArrayList;
import junit.framework.*;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 *
 * @author Mischa Wenger
 */

public class ProfileTest extends TestCase {

    Profile profile;
    CourseProfile cp;
             
   
   // assigning the values
   protected void setUp(){
      profile = new StudentProfile();
      cp = new CourseProfile();
      profile.testInit();
   }

   // test method to add two values
   public void testAddCourseProfile(){
       profile.addCourseProfile(cp);
       assertEquals(cp, profile.getCourseProfiles().get(0));
   }
   
   public void testRemoveCourseProfile(){
       ArrayList<CourseProfile> cpList = new ArrayList<>();
       cpList.add(cp);
       profile.setCourseProfiles(cpList);
       
       profile.removeCourseProfile(cp);
       assertTrue(profile.getCourseProfiles().isEmpty());
       
   }
}
