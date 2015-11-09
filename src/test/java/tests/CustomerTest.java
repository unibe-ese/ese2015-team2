/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import ch.eset2.model.Customer;
import java.util.ArrayList;
import junit.framework.*;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Mischa Wenger
 */

public class CustomerTest extends TestCase {

    Customer customer;
    
   
   protected void setUp(){
      customer = new Customer();
      
   }

   // test method to add two values
   public void testSetMatr(){
       customer.setMatnr("10-100-100");
       assertEquals("10-100-100", customer.getMatnr());
   }
   
   public void testSetMatr2(){
       customer = new Customer();
       customer.setMatnr("99-999-999");
       assertEquals("99-999-999", customer.getMatnr());
   }
}
