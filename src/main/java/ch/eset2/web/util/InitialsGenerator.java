/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.util;

import ch.eset2.model.Customer;

/**
 *
 * @author foxhound
 */
public class InitialsGenerator {
    
    public static String generateInitials(Customer c){
        StringBuilder sb = new StringBuilder();
        return sb.append(c.getFirstName().charAt(0)).append(c.getLastName().charAt(0)).toString();
    }
}
