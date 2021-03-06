package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.util.MessageState;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Responsible to display a message.
 * 
 * @author Mischa Wenger
 * @version 1.0
 */
@Named
@ViewScoped
public class ViewMessageBean implements Serializable {

    private static final long serialVersionUID = 4473459034872303116L;
    
    @Inject
    private MessageFacade messageFacade;
    
    private Customer customer;
    private Message message;
    private boolean inReplyState = false;
    private boolean myMessage = false;
    
    public void init(){
        customer = message.getReceiver();
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        myMessage = loggedInCustomer.getUsername().equals(customer.getUsername());
        message.setMessageState(MessageState.READ);
        messageFacade.edit(message);
    }
    
    // GETTERS AND SETTER
    public boolean isMyMessage(){
        return myMessage;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public boolean isInReplyState() {
        return inReplyState;
    }

    public void setInReplyState(boolean inReplyState) {
        this.inReplyState = inReplyState;
    }
}