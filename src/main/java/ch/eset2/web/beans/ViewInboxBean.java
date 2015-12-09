package ch.eset2.web.beans;

import ch.eset2.model.Customer;
import ch.eset2.model.Message;
import ch.eset2.model.Offer;
import ch.eset2.model.dao.MessageFacade;
import ch.eset2.model.dao.OfferFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.shiro.SecurityUtils;

/**
 * Displays the {@link Message}s and {@link Offer}s of the currently logged in
 * user by checking all the messages/offers in the database with 'receiver'
 * equals to id of the logged in user.
 *
 * @author Mischa Wenger
 * @version 1.0
 */
@Named
@RequestScoped
public class ViewInboxBean implements Serializable {

    private static final long serialVersionUID = 8941173342748853017L;

    @Inject
    private MessageFacade messageFacade;
    
    @Inject
    private OfferFacade offerFacade;
    
    private List<Offer> offers;

    private List<Message> messages;

    private Customer currentUser;

    /**
     * Gets the messages from the database and calls the filter with username of
     * the logged in user.
     */
    @PostConstruct
    private void init() {
        currentUser = (Customer) SecurityUtils.getSubject().getPrincipal();
        messages = messageFacade.findMessageByReceiver(currentUser);
        offers = offerFacade.findOfferByReceiver(currentUser);
    }

    /**
     * Checks whether there are messages or not in the inbox.
     *
     * @return true when there exist messages, false when there are no messages.
     */
    public boolean hasMessages() {
        if (messages == null) {
            return false;
        }
        return !messages.isEmpty();
    }

    /**
     * Checks whether there are offers or not in the inbox.
     *
     * @return true when there exist offers, false when there are no offers.
     */
    public boolean hasOffers() {
        if (offers == null) {
            return false;
        }
        return !offers.isEmpty();
    }
    
    // GETTERS AND SETTER
    public List<Message> getMessages() {
        return messages;
    }
    
    public List<Offer> getOffers() {
        return offers;
    }
}