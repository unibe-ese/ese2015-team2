package ch.eset2.web.util;

import ch.eset2.model.Customer;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 * Provides means to determine a customer's permission to view another profile.
 *
 * @author Marc Jost
 * @version 2.0
 */
@RequestScoped
public class PrivacyHelper implements Serializable {

    private static final long serialVersionUID = -1123881837821798218L;
    
    /**
     * Determines if a customer can view the full profile of another customer.
     *
     * @param loggedInCustomer the customer currently logged in to the app
     * @param viewedCustomer the customer being viewed
     * @return true if loggedInCustomer equals viewedCustomer (e.g. customer is
     *          viewing his/her own profile) or loggedInCustomer is friends with
     *          viewedCustomer; false otherwise
     */
    public boolean hasPermissionToViewFullProfile(Customer loggedInCustomer, Customer viewedCustomer) {
        return loggedInCustomer.equals(viewedCustomer) || loggedInCustomer.getFriends().contains(viewedCustomer);
    }
}