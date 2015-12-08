/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.dao.CustomerFacade;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Provides the means to define a friendship between two {@link Customer}
 * entities.
 *
 * @author Marc Jost
 * @version 2.0
 */
@RequestScoped
@Named
public class AddFriendBean implements Serializable {

    private static final long serialVersionUID = 710525049187893141L;
    
    @Inject
    private CustomerFacade customerFacade;

    public void addFriend(Customer customer, Customer friend) {
        if (!customer.getFriends().contains(friend)) {
            customer.addFriend(friend);
            customerFacade.edit(customer);
            friend.addFriend(customer);
            customerFacade.edit(friend);
        }
    }
}
