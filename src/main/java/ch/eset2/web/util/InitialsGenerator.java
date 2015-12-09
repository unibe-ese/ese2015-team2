package ch.eset2.web.util;

import ch.eset2.model.Customer;

/**
 * Generates Initials from the Customers First and Last Name.
 * E.g. A Customer called Marc Jost would generate initials MJ
 * 
 * @author Marc Jost
 * @version 1.0
 */
public class InitialsGenerator {
    
    /**
     * Generates Initials from the Customers First and Last Name.
     * E.g. A Customer called Marc Jost would generate initials MJ
     * 
     * @param c the customer to generate initials from
     * @return the initials. E.g. Marc Jost returns MJ
     */
    public static String generateInitials(Customer c){
        StringBuilder sb = new StringBuilder();
        return sb.append(c.getFirstName().charAt(0)).append(c.getLastName().charAt(0)).toString();
    }
}