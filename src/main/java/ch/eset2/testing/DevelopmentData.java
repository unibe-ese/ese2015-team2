/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.testing;

import ch.eset2.model.Course;
import ch.eset2.model.Customer;
import ch.eset2.model.dao.CourseFacade;
import ch.eset2.model.dao.CustomerFacade;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * Simple Class to create some initial Data in the database
 * @author foxhound
 */
@Singleton
@Startup
public class DevelopmentData {
    
    @Inject
    private CustomerFacade customerFacade;
    
    @Inject
    private CourseFacade courseFacade;
    
    public DevelopmentData(){
        
    }
    
    @PostConstruct
    public void initializeTestData(){
        createTestUsers();
        createTestCourses();
    }
    
    private void createTestUsers(){
        Customer customer = new Customer();
        customer.setAccountType(1);
        customer.setCity("Bern");
        customer.setFirstName("Marc");
        customer.setLastName("Jost");
        customer.setMatnr("12-108-130");
        customer.setPassword("123");
        customer.setPhone("");
        customer.setStreet("Stöckackerstrasse 98");
        customer.setUsername("marc.jost");
        customer.setZip("3018");
        customerFacade.create(customer);
    }
    
    private void createTestCourses(){
        Course ese = new Course();
        ese.setTitle("Einführung in Software Engineering");
        ese.setDescription("This course is intended for Bachelors students in the third semester studying a major or minor in Computer Science. The goal of this course is to provide an introduction to the key concepts of Software Engineering.");
        ese.setECTS("5");
        ese.setSemester("Fall");
        ese.setLevel("Bachelor");
        courseFacade.create(ese);
        
        Course ei = new Course();
        ei.setTitle("Einführung in die Informatik");
        ei.setDescription("Das Ziel dieser Veranstaltung ist, eine Übersicht über die wichtigsten Themen und Grundbegriffe der Informatik zu vermitteln. ");
        ei.setECTS("5");
        ei.setSemester("Fall");
        ei.setLevel("Bachelor");
        courseFacade.create(ei);
        
        // TODO More
    }
    
    
    
}
