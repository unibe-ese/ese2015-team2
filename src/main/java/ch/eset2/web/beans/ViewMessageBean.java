package ch.eset2.web.beans;


import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible to display a message
 * 
 * @author Marc Jost
 * @version 1.0
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
