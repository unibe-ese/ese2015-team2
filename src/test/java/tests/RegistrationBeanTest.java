/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import ch.eset2.model.Customer;
import ch.eset2.web.beans.RegistrationBean;
import ch.eset2.web.util.Navigation;
import ch.eset2.web.util.ProfileFactory;
import java.util.ArrayList;
import junit.framework.*;
import static junit.framework.Assert.assertEquals;

/**
 *
 * @author Mischa Wenger
 */

public class RegistrationBeanTest extends TestCase {

    RegistrationBean regBean;
    Customer customer;
   
   protected void setUp(){
       regBean = new RegistrationBean();
       customer = new Customer();
       customer.setAccountType(0);
       regBean.setNewCustomer(customer);
   }

   /*
   public void testRegisterNewCustomer(){
       assertEquals(Navigation.REGSUCCESS, regBean.registerNewCustomer());
       
   }

   */
}
