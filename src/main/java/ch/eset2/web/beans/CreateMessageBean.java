package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.converter.DateConverter;
import ch.eset2.web.util.MessageState;
import ch.eset2.web.util.MessageType;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * CreateMessageBean provides a message send service.
 * It allows to persist a new message to the database.
 * {@link CreateMessageBean#init() } should be called from the server before
 * using any service of this class.
 * @author Mischa Wenger / Eve Mendoza
 */
@Named(value = "createMessageBean")
@ViewScoped
public class CreateMessageBean implements Serializable {
    
    @Inject
    private MessageFacade messageFacade;
    
    private Customer receiver;
    
    private Message newMessage;
    /**
     * Creates a new instance of CreateMessageBean
     */
    public CreateMessageBean() {
    }
    
    @PostConstruct
    private void init(){
        newMessage = new Message();
        Customer loggedInCustomer = (Customer) SecurityUtils.getSubject().getPrincipal();
        newMessage.setSender(loggedInCustomer);
    }
    
    
    /**
     * Persists the new message to the database.
     * @param receiver who should receive the message
     * @return the "sendSuccess.xhtml" page to indicate that the message was sent.
     */
    public String createNewMessage(Customer receiver){
        newMessage.setMessageType(MessageType.MESSAGE);
        newMessage.setSendDate(DateConverter.currentTimeAsString());
        newMessage.setMessageState(MessageState.NEW);
        newMessage.setReceiver(receiver);
        messageFacade.create(newMessage);
        return Navigation.SENDSUCCESS;
    }
    
    //getters and setters
    public Message getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(Message newMessage) {
        this.newMessage = newMessage;
    }
        
    public Customer getReceiver() {
        return receiver;
    }

    public void setReceiver(Customer receiver) {
        this.receiver = receiver;
    }
}
