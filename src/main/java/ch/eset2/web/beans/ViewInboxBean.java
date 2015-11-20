package ch.eset2.web.beans;
import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.dao.MessageFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Displays the messages of the current logged in user by checking all the
 * messages in the database with 'reciever' equals to username.
 *
 * @author Mischa Wenger
 * @version 1.0
 */
@Named
@RequestScoped
public class ViewInboxBean implements Serializable {

    @Inject
    private MessageFacade messageFacade;

    private List<Message> messages;

    private Customer currentuser;

    /**
     * Gets the messages from the database and calls the filter with username of
     * the logged in user.
     */
    @PostConstruct
    private void init() {
        
        currentuser = (Customer) SecurityUtils.getSubject().getPrincipal();
        messages = messageFacade.findMessageByReciever(currentuser.getUsername());
    }

    /**
     * Checks whether there are messages or not in the inbox.
     *
     * @return true when there exist messages, false when there are no messages.
     */
    public boolean hasMessages() {
        if (messages == null) {
            System.err.println("MESSAGES IS FUCKING NULL");
            return false;
        }
        System.err.println("MESSAGES of this user: ");
        for (Message message : messages) {
            System.err.println(message.getId());
        }
        System.err.println("RETURNING: " + !messages.isEmpty());
        return !messages.isEmpty();
    }

    
    //getters
    public List<Message> getMessages() {
        return messages;
    }

}
