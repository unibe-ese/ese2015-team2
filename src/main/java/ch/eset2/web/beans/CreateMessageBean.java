package ch.eset2.web.beans;

import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.web.util.Navigation;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * CreateMessageBean provides a message send service.
 * It allows to persist a new message to the database.
 * {@link CreateMessageBean#init() } should be called from the server before
 * using any service of this class.
 * @author Mischa Wenger / Eve Mendoza
 */
@Named(value = "createMessageBean")
@RequestScoped
public class CreateMessageBean implements Serializable {
    
    @Inject
    private MessageFacade messageFacade;
    
    private Message newMessage;
    
    /**
     * Creates a new instance of CreateMessageBean
     */
    public CreateMessageBean() {
    }
    
    @PostConstruct
    private void init(){
        newMessage = new Message();
    }
    
    
    /**
     * Persists the new message to the database.
     * @return the "sendSuccess.xhtml" page to indicate that the message was sent.
     */
    public String createNewMessage(){
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
}
