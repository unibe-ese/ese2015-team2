/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.beans;


import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Profile;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 *
 * @author foxhound
 */
@Named
@ViewScoped
public class ViewMessageBean implements Serializable {
    
    private String customer;
    private Message message;
    
    private boolean myMessage = false;
    
    public void init(){
        customer = message.getReciever();
                
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        myMessage = loggedInCustomer.getUsername().equals(customer);
    }
    
    public boolean isMyMessage(){
        return myMessage;
    }

    /*public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

*/
    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
    
    
    
}
